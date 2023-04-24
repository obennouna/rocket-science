package com.mindera.rocketscience.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.mindera.rocketscience.R
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.utils.MethodUtils

class FilterDialogFragment : DialogFragment() {
    private lateinit var listLaunches: List<Launch>
    private lateinit var listener: NoticeDialogListener
    private var launchesYear: MutableList<String> = mutableListOf()
    private var launchesSuccessBool = BooleanArray(2)
    private var listAsc = true

    companion object {
        private const val LAUNCHES_KEY = "LAUNCHES_KEY"
        fun generateFilterDialogFragment(launches: ArrayList<Launch>): FilterDialogFragment {
            val dialogFragment = FilterDialogFragment()

            val bundle = Bundle()
            bundle.putParcelableArrayList(LAUNCHES_KEY, launches)
            dialogFragment.arguments = bundle

            return dialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Since getParcelable(KEY, Class) is only supported on Tiramisu, we keep using the old way
        listLaunches = requireArguments().getParcelableArrayList(LAUNCHES_KEY)!!

        val filterOptions = arrayOf("Year of Launch", "Success of launch", "Order of launches")

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.menu_filter_label)
                .setItems(filterOptions) { _, i: Int ->
                    when (i) {
                        0 -> displayYearFilter()
                        1 -> displaySuccessFilter()
                        2 -> displayOrder()
                    }
                }
                .setPositiveButton(R.string.confirm) { _, _ ->
                    listener.onDialogPositiveClick(
                        launchesYear,
                        launchesSuccessBool.toList(),
                        listAsc
                    )
                }
                .setNegativeButton(R.string.cancel) { _, _ ->
                    this.dismiss()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun displayYearFilter() {
        val allLaunchesYear =
            listLaunches.map { MethodUtils.getYear(it.date_unix) }.distinct().toTypedArray()
        val allLaunchesBool = BooleanArray(allLaunchesYear.size)
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.menu_filter_label)
                .setMultiChoiceItems(allLaunchesYear, allLaunchesBool) { _, which, isChecked ->
                    allLaunchesBool[which] = isChecked
                }

                .setPositiveButton(R.string.confirm) { _, _ ->
                    for (i in allLaunchesBool.indices) {
                        val checked = allLaunchesBool[i]
                        if (checked) {
                            launchesYear.add(allLaunchesYear[i])
                        }
                    }
                    listener.onDialogPositiveClick(
                        launchesYear,
                        launchesSuccessBool.toList(),
                        listAsc
                    )
                }
                .setNeutralButton(R.string.cancel) { _, _ ->
                    launchesYear = mutableListOf()
                    dismiss()
                }
                .create()
                .show()
        }
    }

    private fun displaySuccessFilter() {
        val allLaunchesSuccess = arrayOf("true", "false")
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.menu_filter_label)
                .setMultiChoiceItems(
                    allLaunchesSuccess,
                    launchesSuccessBool
                ) { _, which, isChecked ->
                    launchesSuccessBool[which] = isChecked
                }
                .setPositiveButton(R.string.confirm) { _, _ ->
                    listener.onDialogPositiveClick(
                        launchesYear,
                        launchesSuccessBool.toList(),
                        listAsc
                    )
                }
                .setNeutralButton(R.string.cancel) { _, _ ->
                    launchesSuccessBool = BooleanArray(2)
                    dismiss()
                }
                .create()
                .show()
        }
    }

    private fun displayOrder() {
        val launchesAscOrDesc = arrayOf("Asc", "Desc")
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.menu_filter_label)
                .setSingleChoiceItems(launchesAscOrDesc, -1) { _, which ->
                    listAsc = which == 0
                }
                .setPositiveButton(R.string.confirm) { _, _ ->
                    listener.onDialogPositiveClick(
                        launchesYear,
                        launchesSuccessBool.toList(),
                        listAsc
                    )
                }
                .setNeutralButton(R.string.cancel) { _, _ ->
                    listAsc = true
                    dismiss()
                }
                .create()
                .show()
        }
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context.toString() +
                        " must implement NoticeDialogListener")
            )
        }
    }

    interface NoticeDialogListener {
        fun onDialogPositiveClick(
            dialog: List<String>,
            launchesSuccess: List<Boolean>,
            listAsc: Boolean
        )
    }
}

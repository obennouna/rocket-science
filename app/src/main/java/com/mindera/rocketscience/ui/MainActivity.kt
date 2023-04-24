package com.mindera.rocketscience.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindera.rocketscience.R
import com.mindera.rocketscience.databinding.ActivityMainBinding
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.mindera.rocketscience.ui.adapter.LaunchesAdapter
import com.mindera.rocketscience.ui.viewmodel.RocketScienceViewModel
import com.mindera.rocketscience.utils.MethodUtils
import okhttp3.internal.notifyAll


class MainActivity : AppCompatActivity(), LaunchesAdapter.OnItemClickListener,
    FilterDialogFragment.NoticeDialogListener {

    private lateinit var launches: List<Launch>
    private lateinit var rocketScienceViewModel: RocketScienceViewModel
    private lateinit var binding: ActivityMainBinding
    private val launchesAdapter = LaunchesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        rocketScienceViewModel = ViewModelProvider(this)[RocketScienceViewModel::class.java]
        rocketScienceViewModel.companyInfoLiveData.observe(this) {
            updateCompanyInfo(it)
        }
        rocketScienceViewModel.launchesLiveData.observe(this) {
            this.launches = it
            updateLaunches(it)
        }
        rocketScienceViewModel.rocketsLiveData.observe(this) {
            updateRockets(it)
        }
        setContentView(binding.root)
        rocketScienceViewModel.getMainData(baseContext)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.filter_list -> {
                displayDialogFilter()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun displayDialogFilter() {
        val dialogFragment = FilterDialogFragment.generateFilterDialogFragment(ArrayList(launches))
        dialogFragment.show(supportFragmentManager, localClassName)
    }

    private fun updateCompanyInfo(companyInfo: CompanyInfo?) {
        if (companyInfo != null) {
            binding.companyInfoContent.text = getString(
                R.string.main_activity_content_company_info,
                companyInfo.name,
                companyInfo.founder,
                companyInfo.founded,
                companyInfo.employees,
                companyInfo.launch_sites,
                companyInfo.valuation
            )
        }
    }

    private fun updateLaunches(launches: List<Launch>) {
        if (launches.isNotEmpty()) {
            binding.launchesItems.setHasFixedSize(true)
            binding.launchesItems.layoutManager = LinearLayoutManager(baseContext)
            binding.launchesItems.itemAnimator = DefaultItemAnimator()
            binding.launchesItems.addItemDecoration(
                DividerItemDecoration(
                    baseContext,
                    DividerItemDecoration.VERTICAL
                )
            )
            launchesAdapter.onItemClickListener(this)
            launchesAdapter.setLaunches(launches)
            binding.launchesItems.adapter = launchesAdapter
        }
    }

    private fun updateRockets(rockets: List<Rocket>) {
        // We need to use the notify withing a synchronized context to avoid an exception
        synchronized(launchesAdapter) {
            launchesAdapter.setRockets(rockets)
            launchesAdapter.notifyAll()
        }
    }

    override fun onItemClickListener(data: Launch) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder
            .setTitle(R.string.title_alert_dialog)
            .setMessage(R.string.content_alert_dialog)
            .setPositiveButton(R.string.wikipedia_label) { _, _ ->
                openIntent(data.links.wikipedia)
            }
            .setNegativeButton(R.string.article_label) { _, _ ->
                openIntent(data.links.article)
            }
            .setNeutralButton(R.string.youtube_label) { _, _ ->
                openIntent(data.links.webcast)
            }
            .create()
            .show()
    }

    private fun openIntent(uri: String?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(browserIntent)
    }

    override fun onDialogPositiveClick(
        dialog: List<String>,
        launchesSuccess: List<Boolean>,
        listAsc: Boolean
    ) {
        val filterSuccess = mutableListOf<Boolean>()
        if (launchesSuccess[0]) {
            filterSuccess.add(true)
        }
        if (launchesSuccess[1]) {
            filterSuccess.add(false)
        }
        var launchesFiltered = emptyList<Launch>()
        if (dialog.isNotEmpty()) {
            launchesFiltered = launches.filter {
                dialog.contains(MethodUtils.getYear(it.date_unix))
            }
        }
        if (filterSuccess.isNotEmpty()) {
            launchesFiltered = launches.filter {
                filterSuccess.contains(it.success)
            }
        }
        if (!listAsc) {
            launchesFiltered = launches.sortedBy { 1 - it.date_unix }
        }
        updateLaunches(launchesFiltered)
    }
}
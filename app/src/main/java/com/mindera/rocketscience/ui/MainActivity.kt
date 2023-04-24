package com.mindera.rocketscience.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
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
import okhttp3.internal.notifyAll


class MainActivity : AppCompatActivity(), LaunchesAdapter.OnItemClickListener {

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
            updateLaunches(it)
        }
        rocketScienceViewModel.rocketsLiveData.observe(this) {
            updateRockets(it)
        }
        setContentView(binding.root)
        rocketScienceViewModel.getMainData(baseContext)
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
}
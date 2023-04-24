package com.mindera.rocketscience.ui

import android.os.Bundle
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
            launchesAdapter.setData(launches)
            binding.launchesItems.adapter = launchesAdapter
        }
    }

    private fun updateRockets(rockets: List<Rocket>?) {
    }

    override fun onItemClickListener(data: Launch) {
        // TODO
    }
}
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
        setContentView(binding.root)
        rocketScienceViewModel.getCompanyInfo(baseContext)
    }

    private fun updateCompanyInfo(companyInfo: CompanyInfo?) {
        if (companyInfo != null) {
            rocketScienceViewModel.getLaunches(baseContext)
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

    private fun updateLaunches(launches: List<Launch>?) {
        binding.launchsItems.setHasFixedSize(true)
        binding.launchsItems.layoutManager = LinearLayoutManager(baseContext)
        binding.launchsItems.itemAnimator = DefaultItemAnimator()
        binding.launchsItems.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))
        launchesAdapter.onItemClickListener(this)
        launches?.let { launchesAdapter.setData(it) }
        binding.launchsItems.adapter = launchesAdapter
    }

    override fun onItemClickListener(data: Launch) {
        // TODO
    }
}
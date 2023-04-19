package com.mindera.rocketscience.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.repository.RocketScienceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RocketScienceViewModel : ViewModel() {
    private val rocketScienceRepository = RocketScienceRepository()
    private val _companyInfo: MutableLiveData<CompanyInfo> = MutableLiveData()
    private val _launches: MutableLiveData<List<Launch>> = MutableLiveData()

    var companyInfoLiveData: LiveData<CompanyInfo> = _companyInfo
    var launchesLiveData: LiveData<List<Launch>> = _launches

    fun getMainData(context: Context) {
        getCompanyInfo(context)
        getLaunches(context)
    }

    fun getCompanyInfo(context: Context) {
        _companyInfo.apply {
            viewModelScope.launch(Dispatchers.Main) {
                value = context.let { rocketScienceRepository.getCompanyInfo(it) }
            }
        }
    }

    fun getLaunches(context: Context) {
        _launches.apply {
            viewModelScope.launch(Dispatchers.Main) {
                rocketScienceRepository.getLaunches(context).collect {
                    value = it
                }
            }
        }
    }
}
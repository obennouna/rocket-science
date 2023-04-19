package com.mindera.rocketscience.repository

import android.content.Context
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.network.RocketScienceClient
import com.mindera.rocketscience.utils.MethodUtils
import kotlinx.coroutines.flow.flow

class RocketScienceRepository {

    /**
     * The reasoning behind this is that the Company Info change hence fetching what was cached only if there is no connection.
     */
    suspend fun getCompanyInfo(context: Context): CompanyInfo? {
        val companyInfoDao = AppDatabase.getInstance(context).companyInfoDao()
        if (!MethodUtils.isOnline(context)) {
            val result = companyInfoDao.getAll()
            if (result != null) {
                return result
            }
        }

        try {
            val response = RocketScienceClient.apiClient.getCompanyInfo()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!
                companyInfoDao.insert(data)
                return data
            }
        } catch (e: Exception) {
            return null
        }
        return null
    }

    /**
     * We use the power of Flows to optimize the response time and not wait for ALL launches to load to display the list
     */
    suspend fun getLaunches(context: Context) = flow {
        val launchDao = AppDatabase.getInstance(context).launchDao()
        if (!MethodUtils.isOnline(context)) {
            val result = launchDao.getAll()
            if (result != null) {
                emit(result)
            }
        }

        try {
            val response = RocketScienceClient.apiClient.getLaunches()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!
                launchDao.insert(data)
                emit(data)
            }
        } catch (e: Exception) {
            emit(null)
        }
        emit(null)
    }
}
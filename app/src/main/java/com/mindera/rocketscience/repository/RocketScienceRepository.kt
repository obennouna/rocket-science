package com.mindera.rocketscience.repository

import android.content.Context
import android.util.Log
import com.mindera.rocketscience.database.AppDatabase
import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import com.mindera.rocketscience.network.RocketScienceClient
import com.mindera.rocketscience.utils.MethodUtils

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

    suspend fun getLaunches(context: Context) : List<Launch> {
        val launchDao = AppDatabase.getInstance(context).launchDao()
        if (!MethodUtils.isOnline(context)) {
            val result = launchDao.getAll()
            if (result != null) {
                return result
            }
        }

        try {
            val response = RocketScienceClient.apiClient.getLaunches()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!
                launchDao.insert(data)
                return data
            }
        } catch (e: Exception) {
            Log.e(RocketScienceRepository::class.simpleName, e.message.toString())
            return emptyList()
        }
        return emptyList()
    }

    suspend fun getRockets(context: Context) : List<Rocket> {
        val rocketDao = AppDatabase.getInstance(context).rocketDao()
        if (!MethodUtils.isOnline(context)) {
            val result = rocketDao.getAll()
            if (result != null) {
                return result
            }
        }

        try {
            val response = RocketScienceClient.apiClient.getRockets()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()!!
                rocketDao.insert(data)
                return data
            }
        } catch (e: Exception) {
            Log.e(RocketScienceRepository::class.simpleName, e.message.toString())
            return emptyList()
        }
        return emptyList()
    }
}
package com.mindera.rocketscience.network

import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import retrofit2.Response
import retrofit2.http.GET

interface RocketScienceInterface {
    @GET("/v4/company")
    suspend fun getCompanyInfo(): Response<CompanyInfo>

    @GET("/v4/launches")
    suspend fun getLaunches(): Response<List<Launch>>
}
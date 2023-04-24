package com.mindera.rocketscience.network

import com.mindera.rocketscience.model.companyinfo.CompanyInfo
import com.mindera.rocketscience.model.launches.Launch
import com.mindera.rocketscience.model.rocket.Rocket
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketScienceInterface {
    @GET("/v4/company")
    suspend fun getCompanyInfo(): Response<CompanyInfo>

    @GET("/v4/launches")
    suspend fun getLaunches(): Response<List<Launch>>

    @GET("/v4/rockets")
    suspend fun getRockets(): Response<List<Rocket>>

    @GET("/v4/rockets/{id}")
    suspend fun getRockets(@Path("id") id: String): Response<List<Launch>>

}
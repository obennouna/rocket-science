package com.mindera.rocketscience.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RocketScienceClient {
    val apiClient: RocketScienceInterface = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com")
        .client(OkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(RocketScienceInterface::class.java)
}
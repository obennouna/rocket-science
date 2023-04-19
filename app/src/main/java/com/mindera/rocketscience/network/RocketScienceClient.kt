package com.mindera.rocketscience.network

import com.mindera.rocketscience.utils.MethodUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RocketScienceClient {
    val apiClient: RocketScienceInterface = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com")
        .client(MethodUtils.buildClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(RocketScienceInterface::class.java)
}
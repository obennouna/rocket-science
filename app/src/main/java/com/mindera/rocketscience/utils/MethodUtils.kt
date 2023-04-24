package com.mindera.rocketscience.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.mindera.rocketscience.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.Period
import java.time.ZoneOffset
import java.util.*

class MethodUtils {
    companion object {
        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
            return false
        }

        fun getDate(time: Int): String {
            val date = Date(time.toLong() * 1000)
            val format = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH)
            return format.format(date)
        }

        fun getYear(time: Int): String {
            val date = Date(time.toLong() * 1000)
            val format = SimpleDateFormat("yyyy", Locale.ENGLISH)
            return format.format(date)
        }

        fun formatDateSinceOrFrom(context: Context, time: Int): String {
            val today = LocalDate.now()
            val from = Instant.ofEpochMilli(time.toLong()).atOffset(ZoneOffset.UTC).toLocalDate()
            return if (today.isBefore(from)) {
                context.getString(R.string.launch_mission_date_label, context.getString(R.string.launch_mission_from_label))
            } else {
                context.getString(R.string.launch_mission_date_label, context.getString(R.string.launch_mission_since_label))
            }
        }

        fun formatDateDifference(context: Context, time: Int): String {
            val today = LocalDate.now()
            val from = Instant.ofEpochMilli(time.toLong() * 1000).atOffset(ZoneOffset.UTC).toLocalDate()
            val period = Period.between(from, today)
            val days = period.days + (period.years * 365)
            return if (today.isEqual(from)) {
                context.getString(R.string.launch_mission_today_label)
            } else {
                context.getString(R.string.launch_mission_date_days, days)
            }
        }

        fun buildClient(): OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
        }
    }
}
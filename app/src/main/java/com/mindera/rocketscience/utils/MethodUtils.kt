package com.mindera.rocketscience.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.format.DateFormat
import android.util.Log
import com.mindera.rocketscience.R
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
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

        fun getDate(time: Long?): String {
            val cal: Calendar = Calendar.getInstance(Locale.ENGLISH)
            if (time != null) {
                cal.timeInMillis = time * 1000
                return DateFormat.format("dd-MM-yyyy", cal)
                    .toString() + " at " + DateFormat.format("HH:mm", cal).toString()
            }
            return "Error"
        }

        fun formatDateDifference(context: Context, time: Long?): String {
            val today = LocalDate.now()
            val from = LocalDate.parse(time.toString(), DateTimeFormatter.BASIC_ISO_DATE)
            val period = Period.between(from, today)
            return if (today.isBefore(from)) {
                context.getString(R.string.launch_mission_date_from, period.days)
            } else {
                context.getString(R.string.launch_mission_date_since, period.days)
            }
        }
    }
}
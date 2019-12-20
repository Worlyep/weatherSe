package com.worlyep.weatherse.base.objects

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager

object Utils {
    fun isNetworkConnected(context: Context?): Boolean {
        val connectivityManager: ConnectivityManager =
            context?.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.isDefaultNetworkActive
    }
}
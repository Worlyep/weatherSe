package com.worlyep.weatherse.objects

import android.util.Log
import com.worlyep.weatherse.BuildConfig

object Logs {
    private const val TAG = "WORLYEP"

    fun catchLogs(msg: String) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, msg)
    }

    fun catchLogs(tag: String?, msg: String) {
        if (BuildConfig.DEBUG)
            Log.e(tag, msg)
    }
}
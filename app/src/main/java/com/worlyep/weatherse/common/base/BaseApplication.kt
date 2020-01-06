package com.worlyep.weatherse.common.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

/**
 * 2020-01-03
 * @author worlyep
 **/
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
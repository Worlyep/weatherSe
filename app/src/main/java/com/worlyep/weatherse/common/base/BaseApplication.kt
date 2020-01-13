package com.worlyep.weatherse.common.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.worlyep.weatherse.di.dataModule
import com.worlyep.weatherse.di.retrofitModule
import com.worlyep.weatherse.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * 2020-01-03
 * @author worlyep
 **/
class BaseApplication : Application() {
    private val diModule = listOf(dataModule, retrofitModule, viewModelModule)

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        startKoin {
            androidContext(applicationContext)
            modules(diModule)
        }
    }
}
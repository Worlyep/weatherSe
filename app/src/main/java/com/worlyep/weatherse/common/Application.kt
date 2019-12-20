package com.worlyep.weatherse.common

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.worlyep.weatherse.common.api.interfaces.InterfaceRestful
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Application : Application() {
    companion object {
        private const val baseUrl = "https://www.metaweather.com/"
        const val imgUrl = baseUrl + "static/img/weather/png/64/"

        fun setRetrofitServer(): InterfaceRestful {
            val okHttpBuilder = OkHttpClient.Builder()
            val okHttpClient = okHttpBuilder
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(InterfaceRestful::class.java)
        }
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
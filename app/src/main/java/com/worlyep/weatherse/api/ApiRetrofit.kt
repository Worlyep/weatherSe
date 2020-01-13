package com.worlyep.weatherse.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 2020-01-03
 * @author worlyep
 **/
object ApiRetrofit {
    private const val baseUrl = "https://www.metaweather.com/"
    const val imgUrl = baseUrl + "static/img/weather/png/64/"

    fun setRetrofit(): ApiInterface = Retrofit.Builder().run {
        this.client(
            OkHttpClient.Builder().let { okHttp ->
                okHttp.readTimeout(5, TimeUnit.MINUTES)
                okHttp.writeTimeout(5, TimeUnit.MINUTES)
                okHttp.build()
            })
        this.baseUrl(baseUrl)
        this.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        this.addConverterFactory(GsonConverterFactory.create()).build()
    }.create(ApiInterface::class.java)
}
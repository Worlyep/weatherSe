package com.worlyep.weatherse.di

import com.worlyep.weatherse.api.ApiInterface
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val API_BASE_URL = "https://www.metaweather.com"
const val API_IMAGE_URL = API_BASE_URL + "static/img/weather/png/64/"

var retrofitModule = module {
    single<ApiInterface> {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
package com.worlyep.weatherse.interfaces

import com.worlyep.weatherse.data.LocationResponse
import com.worlyep.weatherse.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceRestful {
    @GET("api/location/search")
    fun locationSearch(@Query("query") query: String?): Call<ArrayList<WeatherResponse>>

    @GET("api/location/{woeid}")
    fun location(@Path("woeid") woeid: String?): Call<LocationResponse>
}
package com.worlyep.weatherse.interfaces

import com.worlyep.weatherse.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceRestful {
    @GET("api/location/search")
    fun search(@Query("query") query: String?): Call<ArrayList<WeatherResponse>>
}
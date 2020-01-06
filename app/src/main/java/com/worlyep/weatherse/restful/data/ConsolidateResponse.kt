package com.worlyep.weatherse.restful.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.worlyep.weatherse.restful.api.ApiRetrofit

/**
 * 2020-01-03
 * @author worlyep
 **/
data class ConsolidateResponse(
    @SerializedName("id")
    @Expose
    val id: Double,
    @SerializedName("weather_state_name")
    @Expose
    val weatherName: String,
    @SerializedName("weather_state_abbr")
    @Expose
    val weatherAbbr: String,
    @SerializedName("the_temp")
    @Expose
    val temp: Double,
    @SerializedName("humidity")
    @Expose
    val humid: Double
) {
    val weatherIcon: String
        get() = ApiRetrofit.imgUrl + "$weatherAbbr.png"
}
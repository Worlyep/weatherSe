package com.worlyep.weatherse.restful.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * 2020-01-03
 * @author worlyep
 **/
data class WeatherResponse(
    @SerializedName("title")
    @Expose
    val locaName: String,
    @SerializedName("location_type")
    @Expose
    val locaType: String? = null,
    @SerializedName("woeid")
    @Expose
    val woeid: Int? = null,
    @SerializedName("latt_long")
    @Expose
    val locaCode: String? = null
) {
    val woeIdString
        get() = woeid.toString()
}
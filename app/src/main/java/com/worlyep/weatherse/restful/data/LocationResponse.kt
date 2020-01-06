package com.worlyep.weatherse.restful.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * 2020-01-03
 * @author worlyep
 **/
data class LocationResponse(
    @SerializedName("consolidated_weather")
    @Expose
    val consolidateList: List<ConsolidateResponse>
)
package com.worlyep.weatherse.data.restful

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.worlyep.weatherse.data.restful.ConsolidateResponse

/**
 * 2020-01-03
 * @author worlyep
 **/
data class LocationResponse(
    @SerializedName("consolidated_weather")
    @Expose
    val consolidateList: List<ConsolidateResponse>
)
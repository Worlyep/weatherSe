package com.worlyep.weatherse.data

import com.worlyep.weatherse.restful.data.ConsolidateResponse

/**
 * 2020-01-03
 * @author worlyep
 **/
data class DataShowcase(
    var location: String,
    var weatherData: List<ConsolidateResponse>
)
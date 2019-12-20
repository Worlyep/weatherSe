package com.worlyep.weatherse.common.api.data

data class ConsolidateResponse(
    var id: Double? = null,
    var weather_state_name: String? = null,
    var weather_state_abbr: String? = null,
    var the_temp: Double? = null,
    var humidity: Double? = null,
    var consolidate: ConsolidateResponse?
)
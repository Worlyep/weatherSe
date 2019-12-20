package com.worlyep.weatherse.api.data

data class LocationResponse(
    var consolidated_weather: List<ConsolidateResponse>? = null
)
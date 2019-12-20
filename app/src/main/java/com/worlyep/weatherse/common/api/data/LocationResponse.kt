package com.worlyep.weatherse.common.api.data

data class LocationResponse(
    var consolidated_weather: List<ConsolidateResponse>? = null
)
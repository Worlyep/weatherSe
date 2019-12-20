package com.worlyep.weatherse.common.api.data

data class DataShowcase(
    var location: String? = null,
    var weatherData: List<ConsolidateResponse>? = null
)
package com.worlyep.weatherse.api.data

data class DataShowcase(
    var location: String? = null,
    var weatherData: List<ConsolidateResponse>? = null
)
package com.worlyep.weatherse.api.data

data class WeatherResponse(
    var title: String? = null,
    var location_type: String? = null,
    var woeid: Int? = null,
    var latt_long: String? = null
)
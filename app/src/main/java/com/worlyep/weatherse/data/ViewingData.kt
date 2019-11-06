package com.worlyep.weatherse.data

data class WeatherShowcase(var weather: WeatherShowcase?) {
    var location: String? = null
    var weatherData: List<ConsolidatedWeather>? = null
}
package com.worlyep.weatherse.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.worlyep.weatherse.Application

data class WeatherResponse(var weather: WeatherResponse?) {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("location_type")
    @Expose
    var locationType: String? = null
    @SerializedName("woeid")
    @Expose
    var woeid: Int? = null
    @SerializedName("latt_long")
    @Expose
    var lattLong: String? = null
}

data class LocationResponse(var location: LocationResponse?) {
    @SerializedName("consolidated_weather")
    @Expose
    var consolidatedWeather: List<ConsolidatedWeather>? = null
}

data class ConsolidatedWeather(var consolidate: ConsolidatedWeather?) {
    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("weather_state_name")
    @Expose
    var weatherStateName: String? = null
    @SerializedName("weather_state_abbr")
    @Expose
    var weatherStateAbbr: String? = null
        get() = Application.imgUrl + "$field.png"
    @SerializedName("the_temp")
    @Expose
    var theTemp: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null
}
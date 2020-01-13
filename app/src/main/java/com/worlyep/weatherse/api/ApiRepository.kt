package com.worlyep.weatherse.api

class ApiRepository(private val apiInterface: ApiInterface) {
    fun searchLocation(query: String?) = apiInterface.searchLocation(query)
    fun getLocationWeather(woeId: String?) = apiInterface.getLocationWeather(woeId)
}
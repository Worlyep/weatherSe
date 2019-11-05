package com.worlyep.weatherse.objects

import com.worlyep.weatherse.Application
import com.worlyep.weatherse.data.WeatherResponse
import com.worlyep.weatherse.interfaces.BaseCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiRequest {
    fun searchWeather(callBack: BaseCallBack<ArrayList<WeatherResponse>>) {
        val searchWeather = Application.setRetrofitServer().search("se")
        searchWeather.enqueue(object : Callback<ArrayList<WeatherResponse>> {
            override fun onResponse(
                call: Call<ArrayList<WeatherResponse>>,
                response: Response<ArrayList<WeatherResponse>>
            ) {
                if (response.isSuccessful && response.body() != null)
                    callBack.onResultForData(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<WeatherResponse>>, t: Throwable) {
                callBack.onResultFail(t)
            }
        })
    }
}
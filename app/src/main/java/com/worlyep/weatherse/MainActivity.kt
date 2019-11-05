package com.worlyep.weatherse

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.worlyep.weatherse.custom.WeatherInfoLayout
import com.worlyep.weatherse.data.ConsolidatedWeather
import com.worlyep.weatherse.data.LocationResponse
import com.worlyep.weatherse.data.WeatherResponse
import com.worlyep.weatherse.interfaces.BaseCallBack
import com.worlyep.weatherse.objects.ApiRequest
import com.worlyep.weatherse.objects.Logs
import com.worlyep.weatherse.objects.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchWeather()
    }

    private fun searchWeather() {
        if (Utils.isNetworkConnected(this@MainActivity)) {
            ApiRequest.searchWeather(object : BaseCallBack<ArrayList<WeatherResponse>> {
                override fun onResultForData(body: ArrayList<WeatherResponse>?) {
                    if (body != null && body.size > 0) {
                        locationWeather(body[0].woeid)
                    }
                }

                override fun onResultFail(throwable: Throwable?) {
                    Logs.catchLogs(throwable.toString())
                }
            })
        } else
            Toast.makeText(
                this@MainActivity,
                getText(R.string.check_network),
                Toast.LENGTH_LONG
            ).show()
    }

    private fun locationWeather(woeId: Int?) {
        if (Utils.isNetworkConnected(this@MainActivity)) {
            ApiRequest.locationWeather(woeId.toString(), object : BaseCallBack<LocationResponse> {
                override fun onResultForData(body: LocationResponse?) {
                    if (body != null && !(body.consolidatedWeather!!.isNullOrEmpty())) {
                        for (i in 0..1)
                            initView(body.consolidatedWeather!![i])
                    }
                }

                override fun onResultFail(throwable: Throwable?) {
                    Logs.catchLogs(throwable.toString())
                }
            })
        } else
            Toast.makeText(
                this@MainActivity,
                getText(R.string.check_network),
                Toast.LENGTH_LONG
            ).show()
    }

    private fun initView(weather: ConsolidatedWeather) {
        val dailyTotalLayout = WeatherInfoLayout(this@MainActivity)
        dailyTotalLayout.setWeatherIcon(weather.weatherStateAbbr)
        dailyTotalLayout.setWeatherName(weather.weatherStateName)
        dailyTotalLayout.setWeatherTemper((weather.theTemp)?.toInt(), (weather.humidity)?.toInt())
        testLayout.addView(dailyTotalLayout)
    }
}
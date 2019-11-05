package com.worlyep.weatherse

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.worlyep.weatherse.data.WeatherResponse
import com.worlyep.weatherse.interfaces.BaseCallBack
import com.worlyep.weatherse.objects.ApiRequest
import com.worlyep.weatherse.objects.Logs
import com.worlyep.weatherse.objects.Utils

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
                    Logs.catchLogs(body.toString())
                    if (body != null && body.size > 0) {
                        Logs.catchLogs("${body.size}")
                        Logs.catchLogs("${body[0].title}")
                        Logs.catchLogs("${body[0].lattLong}")
                        Logs.catchLogs("${body[0].locationType}")
                        Logs.catchLogs("${body[0].weather}")
                        Logs.catchLogs("${body[0].woeid}")
                    }
                }

                override fun onResultFail(throwable: Throwable?) {
                    Logs.catchLogs(throwable.toString())
                }
            })
        } else
            Toast.makeText(this@MainActivity, "aaa", Toast.LENGTH_LONG).show()
    }
}
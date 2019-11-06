package com.worlyep.weatherse

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.worlyep.weatherse.adapter.WeatherAdapter
import com.worlyep.weatherse.data.LocationResponse
import com.worlyep.weatherse.data.WeatherResponse
import com.worlyep.weatherse.data.WeatherShowcase
import com.worlyep.weatherse.interfaces.BaseCallBack
import com.worlyep.weatherse.objects.ApiRequest
import com.worlyep.weatherse.objects.Logs
import com.worlyep.weatherse.objects.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutMgr: LinearLayoutManager
    private val adapter: WeatherAdapter by lazy { WeatherAdapter(this@MainActivity) }
    private var weatherShowcaseList: ArrayList<WeatherShowcase>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutMgr = LinearLayoutManager(this@MainActivity)
        weatherList.layoutManager = linearLayoutMgr
        weatherList.adapter = adapter

        initData()
    }

    private fun initData() {
        searchWeather()
        weatherShowcaseList?.let { adapter.setList(it) }
    }

    private fun searchWeather() {
        if (Utils.isNetworkConnected(this@MainActivity)) {
            ApiRequest.searchWeather(object : BaseCallBack<ArrayList<WeatherResponse>> {
                override fun onResultForData(body: ArrayList<WeatherResponse>?) {
                    if (body != null && body.size > 0) {
                        for (i in 0 until body.size) {
                            locationWeather(body[i].title, body[i].woeid)
                        }
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

    private fun locationWeather(location: String?, woeId: Int?) {
        if (Utils.isNetworkConnected(this@MainActivity)) {
            ApiRequest.locationWeather(woeId.toString(), object : BaseCallBack<LocationResponse> {
                override fun onResultForData(body: LocationResponse?) {
                    if (body != null && !(body.consolidatedWeather!!.isNullOrEmpty())) {
                        val weatherShowcase = WeatherShowcase(null).apply {
                            this.location = location
                            this.weatherData = (body.consolidatedWeather)?.subList(0, 2)
                        }
                        weatherShowcaseList?.add(weatherShowcase)
                        Logs.catchLogs(weatherShowcaseList.toString())
                        adapter.notifyDataSetChanged()
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
}
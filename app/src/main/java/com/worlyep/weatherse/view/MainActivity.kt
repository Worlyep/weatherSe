package com.worlyep.weatherse.view

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.api.data.LocationResponse
import com.worlyep.weatherse.common.api.data.WeatherResponse
import com.worlyep.weatherse.common.api.data.DataShowcase
import com.worlyep.weatherse.common.api.interfaces.BaseCallBack
import com.worlyep.weatherse.common.objects.ApiRequest
import com.worlyep.weatherse.common.objects.Logs
import com.worlyep.weatherse.common.objects.Utils
import com.worlyep.weatherse.view.apapter.WeatherAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val linearLayoutMgr: LinearLayoutManager by lazy { LinearLayoutManager(this@MainActivity) }
    private val adapter: WeatherAdapter by lazy { WeatherAdapter(this@MainActivity) }
    private var showcaseList: ArrayList<DataShowcase>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherList.layoutManager = linearLayoutMgr
        weatherList.adapter = adapter

        setData()

        refreshLayout.setOnRefreshListener {
            if (showcaseList?.size!! > 0)
                showcaseList = ArrayList()
            setData()
        }
    }

    private fun setData() {
        weatherList.visibility = View.GONE
        if (!refreshLayout.isRefreshing) {
            progress.visibility = View.VISIBLE
        }
        showcaseList?.let { adapter.setList(it) }
        searchWeather()
    }

    private fun searchWeather() {
        ApiRequest.searchWeather(object : BaseCallBack<ArrayList<WeatherResponse>> {
            override fun onResultForData(body: ArrayList<WeatherResponse>?) {
                if (!body.isNullOrEmpty()) {
                    for (i in 0 until body.size) {
                        locationWeather(body[i].title, body[i].woeid)
                    }
                }
            }

            override fun onResultFail(throwable: Throwable?) {
                Logs.catchLogs(throwable.toString())
            }
        })
    }

    private fun locationWeather(location: String?, woeId: Int?) {
        if (Utils.isNetworkConnected(this@MainActivity)) {
            ApiRequest.locationWeather(woeId.toString(), object : BaseCallBack<LocationResponse> {
                override fun onResultForData(body: LocationResponse?) {
                    body?.run {
                        if (!(this.consolidated_weather!!.isNullOrEmpty())) {
                            showcaseList?.add(
                                DataShowcase(
                                    location,
                                    (this.consolidated_weather)?.subList(0, 2)
                                )
                            )
                            Logs.catchLogs(showcaseList.toString())
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

        Handler().postDelayed({
            adapter.notifyDataSetChanged()
            weatherList.visibility = View.VISIBLE
            if (refreshLayout.isRefreshing) {
                refreshLayout.isRefreshing = false
            } else {
                progress.visibility = View.GONE
            }
        }, 5000)
    }
}
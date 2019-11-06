package com.worlyep.weatherse.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.worlyep.weatherse.R
import com.worlyep.weatherse.custom.WeatherInfoLayout
import com.worlyep.weatherse.data.ConsolidatedWeather
import com.worlyep.weatherse.data.WeatherShowcase
import com.worlyep.weatherse.objects.Logs
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter(private val context: Context?) :
    RecyclerView.Adapter<WeatherAdapter.PostureViewHolder>() {
    private var weatherList: ArrayList<WeatherShowcase> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PostureViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_weather, viewGroup, false)
        return PostureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    fun setList(list: ArrayList<WeatherShowcase>) {
        weatherList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostureViewHolder, position: Int) {
        if (weatherList.size > 0) {
            val weather: WeatherShowcase? = weatherList[position]
            weather?.run {
                holder.locationName.text = this.location
                for (i in 0 until 2) {
                    this.weatherData?.get(i)?.run { initView(this, holder.weatherLayout) }
                    Logs.catchLogs(this.location, this.weatherData?.get(i).toString())
                }
            }
        }
    }

    class PostureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val locationName: TextView = itemView.locationName
        val weatherLayout: LinearLayout = itemView.weatherLayout
    }

    private fun initView(weather: ConsolidatedWeather, weatherLayout: LinearLayout) {
        val dailyTotalLayout = WeatherInfoLayout(context)
        dailyTotalLayout.setWeatherIcon(weather.weatherStateAbbr)
        dailyTotalLayout.setWeatherName(weather.weatherStateName)
        dailyTotalLayout.setWeatherTemper((weather.theTemp)?.toInt(), (weather.humidity)?.toInt())
        weatherLayout.addView(dailyTotalLayout)
    }
}
package com.worlyep.weatherse.view.apapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.Application
import com.worlyep.weatherse.common.api.data.ConsolidateResponse
import com.worlyep.weatherse.common.api.data.DataShowcase
import com.worlyep.weatherse.view.custom.WeatherInfoLayout
import com.worlyep.weatherse.view.holder.WeatherViewHolder

class WeatherAdapter :
    RecyclerView.Adapter<WeatherViewHolder>() {
    private var isHeader: Boolean = false
    private var weatherList: ArrayList<DataShowcase> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WeatherViewHolder {
        lateinit var view: View
        return if (viewType == 0) {
            isHeader = true
            view =
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_header_weather, viewGroup, false)
            WeatherViewHolder(view, true)
        } else {
            isHeader = false
            view =
                LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_weather, viewGroup, false)
            WeatherViewHolder(view, false)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return weatherList.size + 1
    }

    fun setList(list: ArrayList<DataShowcase>) {
        if (weatherList.size > 0)
            weatherList = ArrayList()
        weatherList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        if (weatherList.size > 0 && position > 0) {
            val weather: DataShowcase? = weatherList[position - 1]
            weather?.run {
                holder.locationName.text = this.location
                initWeatherLayout(this.weatherData?.get(0), holder.todayLayout)
                initWeatherLayout(this.weatherData?.get(1), holder.tomorrowLayout)
            }
        }
    }

    private fun initWeatherLayout(weather: ConsolidateResponse?, weatherLayout: WeatherInfoLayout) {
        weather?.run {
            weatherLayout.setWeatherIcon(getIconUrl(this.weather_state_abbr))
            weatherLayout.setWeatherName(this.weather_state_name)
            weatherLayout.setWeatherTemper(this.the_temp, this.humidity)
        }
    }

    private fun getIconUrl(addr: String?): String = Application.imgUrl + "$addr.png"
}
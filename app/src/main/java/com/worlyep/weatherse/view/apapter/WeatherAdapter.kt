package com.worlyep.weatherse.view.apapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.worlyep.weatherse.R
import com.worlyep.weatherse.api.data.ConsolidateResponse
import com.worlyep.weatherse.api.data.DataShowcase
import com.worlyep.weatherse.base.Application
import com.worlyep.weatherse.view.custom.WeatherInfoLayout
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter(private val context: Context?) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private var isHeader: Boolean = false
    private var weatherList: ArrayList<DataShowcase> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        lateinit var view: View
        return if (viewType == 0) {
            isHeader = true
            view =
                LayoutInflater.from(context).inflate(R.layout.item_header_weather, viewGroup, false)
            ViewHolder(view, true)
        } else {
            isHeader = false
            view = LayoutInflater.from(context).inflate(R.layout.item_weather, viewGroup, false)
            ViewHolder(view, false)
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (weatherList.size > 0 && position > 0) {
            val weather: DataShowcase? = weatherList[position - 1]
            weather?.run {
                holder.locationName.text = this.location
                initWeatherLayout(this.weatherData?.get(0), holder.todayLayout)
                initWeatherLayout(this.weatherData?.get(1), holder.tomorrowLayout)

                /*
                // 동적으로 레이아웃을 추가하기 위해 넣었던 코드
                // 의도대로 동작하지 않아 주석 처리함
                for (i in 0 until 2) {
                    this.weatherData?.get(i)?.run {
                        initView(this, holder.weatherLayout)
                    }
                    Logs.catchLogs(this.location, this.weatherData?.get(i).toString())
                }*/
            }
        }
    }

    class ViewHolder(itemView: View, headerFlag: Boolean) : RecyclerView.ViewHolder(itemView) {
        lateinit var locationName: TextView
        lateinit var todayLayout: WeatherInfoLayout
        lateinit var tomorrowLayout: WeatherInfoLayout

        init {
            if (!headerFlag) {
                locationName = itemView.locationTitle
                todayLayout = itemView.todayTitle
                tomorrowLayout = itemView.tomorrowTitle
            }
        }

        // 동적 레이아웃 처리를 위한 레이아웃
        //   val weatherLayout: LinearLayout = itemView.weatherLayout
    }

    private fun initWeatherLayout(weather: ConsolidateResponse?, weatherLayout: WeatherInfoLayout) {
        weather?.run {
            weatherLayout.setWeatherIcon(getIconUrl(this.weather_state_abbr))
            weatherLayout.setWeatherName(this.weather_state_name)
            weatherLayout.setWeatherTemper((this.the_temp)?.toInt(), (this.humidity)?.toInt())
        }
    }

    // 동적으로 레이아웃을 추가하기 위해 넣었던 코드
    // 의도대로 동작하지 않아 주석 처리함
    private fun initView(weather: ConsolidateResponse, weatherLayout: LinearLayout) {
        val dailyTotalLayout =
            WeatherInfoLayout(context)
        dailyTotalLayout.setWeatherIcon(getIconUrl(weather.weather_state_abbr))
        dailyTotalLayout.setWeatherName(weather.weather_state_name)
        dailyTotalLayout.setWeatherTemper((weather.the_temp)?.toInt(), (weather.humidity)?.toInt())
        weatherLayout.addView(dailyTotalLayout)
    }

    private fun getIconUrl(addr: String?): String = Application.imgUrl + "$addr.png"

}
package com.worlyep.weatherse.view.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.worlyep.weatherse.view.custom.WeatherInfoLayout
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherViewHolder(itemView: View, headerFlag: Boolean) :
    RecyclerView.ViewHolder(itemView) {
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
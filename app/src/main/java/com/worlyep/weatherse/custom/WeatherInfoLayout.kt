package com.worlyep.weatherse.custom

import android.content.Context
import android.text.Html
import android.text.Spanned
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import com.bumptech.glide.Glide
import com.worlyep.weatherse.R
import kotlinx.android.synthetic.main.layout_weather_info.view.*

class WeatherInfoLayout : LinearLayout {
    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    private fun initView() {
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(infService) as LayoutInflater
        val v = li.inflate(R.layout.layout_weather_info, this, false)
        addView(v)
    }

    internal fun setWeatherName(name: String?) {
        weatherName.text = name
    }

    internal fun setWeatherIcon(iconUrl: String?) {
        Glide.with(context).load(iconUrl).into(weatherIcon)
    }

    internal fun setWeatherTemper(temper: Int?, humid: Int?) {
        val text: String = context.getString(R.string.weather_temper_humid, temper, humid)
        val styledText: Spanned = Html.fromHtml(text, FROM_HTML_MODE_LEGACY)
        weatherTemp.text = styledText
    }
}
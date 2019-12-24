package com.worlyep.weatherse.view.custom

import android.content.Context
import android.content.res.TypedArray
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
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs) {
        initView()
        getAttrs(attrs, defStyle)
    }

    private fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.WeatherInfoLayout)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.WeatherInfoLayout, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
        val iconUrl = typedArray.getString(R.styleable.WeatherInfoLayout_weatherIcon)
        val name = typedArray.getString(R.styleable.WeatherInfoLayout_weatherName)
        val humid = typedArray.getFloat(R.styleable.WeatherInfoLayout_weatherHumid, 0f).toDouble()
        val temper = typedArray.getFloat(R.styleable.WeatherInfoLayout_weatherTemper, 0f).toDouble()

        Glide.with(context).load(iconUrl).into(weatherIcon)
        weatherName.text = name
        setWeatherTemper(temper, humid)

        typedArray.recycle()
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

    internal fun setWeatherTemper(temper: Double?, humid: Double?) {
        val text: String =
            context.getString(R.string.weather_temper_humid, temper?.toInt(), humid?.toInt())
        val styledText: Spanned = Html.fromHtml(text, FROM_HTML_MODE_LEGACY)

        weatherTemp.text = styledText
    }
}
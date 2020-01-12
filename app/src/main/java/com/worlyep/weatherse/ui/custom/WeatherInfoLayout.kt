package com.worlyep.weatherse.ui.custom

import android.content.Context
import android.text.Html
import android.text.Spanned
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.worlyep.weatherse.R
import com.worlyep.weatherse.databinding.LayoutWeatherInfoBinding
import com.worlyep.weatherse.restful.data.ConsolidateResponse

class WeatherInfoLayout : LinearLayout {
    private lateinit var binding: LayoutWeatherInfoBinding

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, data: ConsolidateResponse) : super(context) {
        initView(data)
    }

    private fun initView(data: ConsolidateResponse) {
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(infService) as LayoutInflater

        binding = DataBindingUtil.inflate(li, R.layout.layout_weather_info, this, false)
        binding.data = data
        addView(binding.root)
    }
}
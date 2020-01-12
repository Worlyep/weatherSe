package com.worlyep.weatherse.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.worlyep.weatherse.R
import com.worlyep.weatherse.data.restful.ConsolidateResponse
import com.worlyep.weatherse.databinding.LayoutWeatherInfoBinding

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
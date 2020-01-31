package com.worlyep.weatherse.ui.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.base.BaseActivity
import com.worlyep.weatherse.databinding.ActivityWeatherBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * 2020-01-03
 * @author worlyep
 **/
class WeatherActivity : BaseActivity<ActivityWeatherBinding>() {
    @LayoutRes
    override fun getLayoutId(): Int = R.layout.activity_weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this

        binding.viewModel?.setData()
    }
}
package com.worlyep.weatherse.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.base.BaseActivity
import com.worlyep.weatherse.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * 2020-01-03
 * @author worlyep
 **/
class MainActivity : BaseActivity<ActivityMainBinding>() {
    @LayoutRes
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickSearch(view: View) {
        binding.viewModel?.setData()
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
    }
}
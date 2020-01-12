package com.worlyep.weatherse.ui.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProviders
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.base.BaseActivity
import com.worlyep.weatherse.common.utils.LogUtils
import com.worlyep.weatherse.databinding.ActivityMainBinding
import com.worlyep.weatherse.ui.viewModel.MainViewModel

/**
 * 2020-01-03
 * @author worlyep
 **/
class MainActivity : BaseActivity<ActivityMainBinding>() {
    @LayoutRes
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = vm
        binding.lifecycleOwner = this

        binding.viewModel?.setData()
        LogUtils.catchLogs(binding.viewModel?.showcaseList?.value.toString())
    }
}
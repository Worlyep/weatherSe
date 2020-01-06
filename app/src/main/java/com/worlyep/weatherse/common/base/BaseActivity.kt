package com.worlyep.weatherse.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders

/**
 * 2020-01-03
 * @author worlyep
 **/
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: VB
        private set

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }
}
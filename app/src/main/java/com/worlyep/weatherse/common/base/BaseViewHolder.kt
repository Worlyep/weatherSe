package com.worlyep.weatherse.common.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * 2020-01-03
 * @author worlyep
 **/
abstract class BaseViewHolder<VB : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
    val binding: VB = DataBindingUtil.bind(view)!!
}
package com.worlyep.weatherse.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.worlyep.weatherse.R
import com.worlyep.weatherse.common.utils.LogUtils
import com.worlyep.weatherse.data.DataShowcase
import com.worlyep.weatherse.databinding.ItemHeaderWeatherBinding
import com.worlyep.weatherse.databinding.ItemWeatherBinding
import com.worlyep.weatherse.ui.holder.WeatherHeaderViewHolder
import com.worlyep.weatherse.ui.holder.WeatherViewHolder
import com.worlyep.weatherse.ui.viewModel.WeatherViewModel

/**
 * 2020-01-03
 * @author worlyep
 **/
class WeatherAdapter(var showCaseList: ArrayList<DataShowcase>, val viewModel: WeatherViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return showCaseList.size + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> WeatherHeaderViewHolder(
                DataBindingUtil.inflate<ItemHeaderWeatherBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_header_weather,
                    parent,
                    false
                ).root
            )
            else -> WeatherViewHolder(
                DataBindingUtil.inflate<ItemWeatherBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_weather,
                    parent,
                    false
                ).root
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        LogUtils.catchLogs("adapter??", showCaseList.toString())
        if (holder is WeatherViewHolder) {
            holder.binding.data = showCaseList[position - 1]
            holder.binding.viewModel = viewModel
            //    holder.binding.executePendingBindings()
        }
    }

    private fun clear() {
        if (showCaseList.isNotEmpty())
            showCaseList.clear()
    }
}
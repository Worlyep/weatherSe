package com.worlyep.weatherse.common.utils

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.worlyep.weatherse.R
import com.worlyep.weatherse.data.DataShowcase
import com.worlyep.weatherse.ui.adapter.WeatherAdapter
import com.worlyep.weatherse.ui.custom.WeatherInfoLayout
import com.worlyep.weatherse.ui.viewModel.WeatherViewModel

@BindingAdapter("refresh")
fun SwipeRefreshLayout.refresh(visible: Boolean) {
    isRefreshing = visible
}

@BindingAdapter("visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["viewModel", "data"])
fun RecyclerView.setAdapter(vm: WeatherViewModel, items: LiveData<ArrayList<DataShowcase>>) {
    this.adapter?.let {
        if (it is WeatherAdapter) {
            it.showCaseList = items.value!!
            it.notifyDataSetChanged()
        }
    } ?: let {
        WeatherAdapter(items.value!!, vm).apply {
            it.adapter = this
        }
    }
}

@BindingAdapter("weatherData")
fun setWeatherInfo(view: LinearLayout, item: DataShowcase) {
    view.removeAllViews()

    for (i in item.weatherData.indices) {
        view.addView(WeatherInfoLayout(view.context, item.weatherData[i]))
    }
}

@BindingAdapter("iconUrl")
fun setWeatherIcon(view: ImageView, iconUrl: String?) {
    Glide.with(view.context).load(iconUrl).into(view)
}

@BindingAdapter(value = ["temper", "humid"])
fun setWeatherTemper(view: TextView, temper: Double?, humid: Double?) {
    val text: String =
        view.context.getString(R.string.weather_temper_humid, temper?.toInt(), humid?.toInt())
    view.text = Html.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
}
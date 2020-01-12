package com.worlyep.weatherse.ui.holder

import android.view.View
import com.worlyep.weatherse.common.base.BaseViewHolder
import com.worlyep.weatherse.databinding.ItemHeaderWeatherBinding
import com.worlyep.weatherse.databinding.ItemWeatherBinding

/**
 * 2020-01-03
 * @author worlyep
 *
 * BaseViewHolder 에 ViewDataBinding 을 넘긴 이유?
 * - HeaderView 와 ItemView 가 따로 있는데,
 *   각각의 뷰 홀더를 생성하지 않기 위한 의도로 만듦
 **/
class WeatherViewHolder(itemView: View) :
    BaseViewHolder<ItemWeatherBinding>(itemView)

class WeatherHeaderViewHolder(itemView: View) :
    BaseViewHolder<ItemHeaderWeatherBinding>(itemView)
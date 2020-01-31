package com.worlyep.weatherse.ui.viewModel

import com.worlyep.weatherse.api.ApiRepository
import com.worlyep.weatherse.common.base.BaseViewModel

/**
 * 2020-01-03
 * @author worlyep
 * @note.RxJava 노트
 * ## RxJava / RxAndroid 제공하는 스케쥴러 섹션 참조
 **/
class MainViewModel(private val model: ApiRepository) : BaseViewModel()
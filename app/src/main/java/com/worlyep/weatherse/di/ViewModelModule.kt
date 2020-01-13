package com.worlyep.weatherse.di

import com.worlyep.weatherse.ui.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}
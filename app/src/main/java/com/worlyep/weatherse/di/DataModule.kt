package com.worlyep.weatherse.di

import com.worlyep.weatherse.api.ApiRepository
import org.koin.dsl.module

var dataModule = module {
    factory {
        ApiRepository(get())
    }
}
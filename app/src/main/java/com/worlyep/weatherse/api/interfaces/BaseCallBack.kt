package com.worlyep.weatherse.api.interfaces

interface BaseCallBack<T> {
    fun onResultForData(body: T?)

    fun onResultFail(throwable: Throwable?)
}
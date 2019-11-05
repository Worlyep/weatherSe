package com.worlyep.weatherse.interfaces

interface BaseCallBack<T> {
    fun onResultForData(body: T?)

    fun onResultFail(throwable: Throwable?)
}
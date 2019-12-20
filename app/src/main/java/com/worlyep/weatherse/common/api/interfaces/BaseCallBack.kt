package com.worlyep.weatherse.common.api.interfaces

interface BaseCallBack<T> {
    fun onResultForData(body: T?)

    fun onResultFail(throwable: Throwable?)
}
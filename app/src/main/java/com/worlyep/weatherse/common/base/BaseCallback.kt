package com.worlyep.weatherse.common.base

/**
 * 2020-01-03
 * @author worlyep
 **/
interface BaseCallback<T> {
    fun onResultForData(body: T)

    fun onResultFail(throwable: Throwable)
}
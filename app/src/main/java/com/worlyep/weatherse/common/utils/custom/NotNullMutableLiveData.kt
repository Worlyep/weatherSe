package com.worlyep.weatherse.common.utils.custom

import androidx.lifecycle.MutableLiveData

class NotNullMutableLiveData<T>(defaultValue: T) : MutableLiveData<T>() {
    init {
        defaultValue?.run {
            value = defaultValue
        } ?: throw Exception("NPE! `defaultValue` must not be null!")
    }

    override fun getValue(): T? = super.getValue()!!
}
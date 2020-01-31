package com.worlyep.weatherse.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import com.worlyep.weatherse.api.ApiRepository
import com.worlyep.weatherse.common.base.BaseViewModel
import com.worlyep.weatherse.common.utils.LogUtils
import com.worlyep.weatherse.common.utils.custom.NotNullMutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model: ApiRepository) : BaseViewModel() {
    private val _loadComplete: NotNullMutableLiveData<Boolean> =
        NotNullMutableLiveData(false)
    val loadComplete: LiveData<Boolean>
        get() = _loadComplete

    fun setData() {
        addDisposable(searchWeather("se"))
    }

    private fun searchWeather(query: String = ""): Disposable =
        model.searchLocation(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _loadComplete.value = true
            }.doAfterSuccess {
                _loadComplete.value = false

            }
            .subscribe({
                if (it.isNotEmpty()) {
                    Log.e("data", it.toString())
                }
            }, { t ->
                LogUtils.catchLogs(t.toString())
                _loadComplete.value = false
            })
}
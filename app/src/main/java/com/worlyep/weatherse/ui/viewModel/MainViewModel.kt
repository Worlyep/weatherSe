package com.worlyep.weatherse.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.worlyep.weatherse.common.base.BaseViewModel
import com.worlyep.weatherse.common.utils.LogUtils
import com.worlyep.weatherse.common.utils.custom.NotNullMutableLiveData
import com.worlyep.weatherse.data.DataShowcase
import com.worlyep.weatherse.api.ApiRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * 2020-01-03
 * @author worlyep
 * @note.RxJava 노트
 * ## RxJava / RxAndroid 제공하는 스케쥴러 섹션 참조
 **/
class MainViewModel : BaseViewModel() {
    private val _visibility: NotNullMutableLiveData<Boolean> =
        NotNullMutableLiveData(false)
    val visibility: LiveData<Boolean>
        get() = _visibility

    private val _refreshing: NotNullMutableLiveData<Boolean> =
        NotNullMutableLiveData(false)
    val refreshing: LiveData<Boolean>
        get() = _refreshing

    private val _showcaseList: MutableLiveData<ArrayList<DataShowcase>> =
        MutableLiveData(arrayListOf())
    val showcaseList: LiveData<ArrayList<DataShowcase>>
        get() = _showcaseList

    private val list: ArrayList<DataShowcase> = ArrayList()

    override fun onCleared() {
        super.onCleared()
        clearData()
    }

    fun setData() {
        clearData()
        addDisposable(searchWeather("se"))
    }

    fun refreshData() {
        _refreshing.value = true
        _visibility.value = false
        setData()
    }

    private fun clearData() {
        if (list.isNotEmpty()) {
            list.clear()
        }
        _showcaseList.value = list
    }

    private fun searchWeather(query: String = ""): Disposable =
        ApiRetrofit.setRetrofit().searchLocation(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _refreshing.value = true
                _visibility.value = false
            }
            .subscribe({
                if (it.isNotEmpty()) {
                    for (i in it.indices) {
                        addDisposable(locationWeather(it[i].locaName, it[i].woeIdString))
                    }
                }
            }, { t ->
                LogUtils.catchLogs(t.toString())
                _refreshing.value = false
                _visibility.value = false
            })

    private fun locationWeather(name: String, woeId: String): Disposable =
        ApiRetrofit.setRetrofit().getLocationWeather(woeId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess {
                _refreshing.value = false
                _visibility.value = true
            }
            .subscribe({
                if (it.consolidateList.isNotEmpty()) {
                    list.add(DataShowcase(name, it.consolidateList.subList(0, 2)))
                    _showcaseList.value = list
                }
            }, { t ->
                LogUtils.catchLogs(t.toString())
                _refreshing.value = false
                _visibility.value = false
            })
}
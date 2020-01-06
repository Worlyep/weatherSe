package com.worlyep.weatherse.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 2020-01-03
 * @author worlyep
 **/
open class BaseViewModel : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()

    /**
     * "why not .dispose()?"
     *
     * = .clear() 와 .dispose() -> 등록된 Disposable 객체를 삭제하는 역할
     * = 이후 동작이 다름
     * = .clear()은 계속 Disposable 을 받을 수 O
     * = .dispose()는 isDisposed() 새로운 Disposable 을 받을 수 X
     *   (메소드를 true로 설정해 버리기 때문에)
     */
    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }
}
package com.deltax72.informationboard.presentation.base.fragments

import androidx.lifecycle.ViewModel
import com.deltax72.informationboard.presentation.utils.livedata.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.untilDestroyed() = compositeDisposable.add(this)

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    //=================================================================

    private val toastMessageLiveEvent by lazy {
        SingleLiveEvent<String>()
    }

    fun toast(message: String) {
//        toastMessageLiveEvent.value = message
        toastMessageLiveEvent.postValue(message)
    }
}
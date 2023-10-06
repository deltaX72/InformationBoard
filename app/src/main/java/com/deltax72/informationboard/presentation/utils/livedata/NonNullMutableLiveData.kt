package com.deltax72.informationboard.presentation.utils.livedata

import androidx.lifecycle.LiveData

@Suppress("UNCHECKED_CAST")
class NonNullMutableLiveData<T>(value: T) : LiveData<T>(value) {

    override fun getValue(): T = super.getValue() as T

    public override fun setValue(value: T) = super.setValue(value)

    public override fun postValue(value: T) = super.postValue(value)
}
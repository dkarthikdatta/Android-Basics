package com.example.myapplication.mvvmlivedata.view.vm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class TempLiveData<T> {
    private var mValue: T? = null

    private val hashMap: HashMap<(T?) -> Unit, LifecycleOwner> = hashMapOf()

    fun setValue(value: T) {
        mValue = value
        for ((observer, owner) in hashMap) {
            if (owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                observer.invoke(value)
            }
        }
    }

    fun observe(owner: LifecycleOwner, observer: (T?) -> Unit) {
        hashMap.put(observer, owner)
    }
}
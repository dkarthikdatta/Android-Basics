package com.example.myapplication.mvvmlivedata.view.vm

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * The issue with livedata -> when screen is rotated, activity is recreated.
 * onCreate is called again but view model is not destroyed(same vm -> lifecycle aware).
 * which means, the observer will listen to livedata once again on anCreate
 *
 *
 * The AtomicBoolean class gives you a boolean value that you can update atomically.
 * Use it when you have multiple threads accessing a boolean variable
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {
    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner, Observer { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })

    }

    @MainThread
    override fun setValue(value: T) {
        pending.set(true)
        super.setValue(value)
    }

    //
//    @MainThread
//    fun call(){
//        value = null
//    }
    companion object {
        private val TAG = "SingleLiveEvent"
    }
}
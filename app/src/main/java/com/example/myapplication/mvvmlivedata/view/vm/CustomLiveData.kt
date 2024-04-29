package com.example.myapplication.mvvmlivedata.view.vm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent

class CustomLiveData<T> {

    //basic setters for a variable
    private var mValue: T? = null

    //can have any number of observers, hence list
//    private val mObservers = HashMap<(T?) -> Unit, LifecycleOwner>()
    private val mObservers = HashMap<(T?) -> Unit, LiveDataLifeCycleObserver>()


    fun setValue(value: T) {
        mValue = value

//        for ((observer, lifeCycleOwner) in mObservers) {
//            if (lifeCycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
//                observer.invoke(mValue)
//            }
//        }

        for(lifecycleObservers in mObservers.values){
            if(lifecycleObservers.owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
                notifyChange(lifecycleObservers)
            }
        }
    }

    fun getValue(): T? {
        return mValue
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: (T?) -> Unit) {
        val lifecycleObserver = LiveDataLifeCycleObserver(lifecycleOwner, observer)
        mObservers.put(observer, lifecycleObserver)
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver) // to automatically get callbacks onStart, onRemove
    }


    fun removeObserver(observer: (T?) -> Unit){
        val lifecycleObserver = mObservers.remove(observer)
        lifecycleObserver?.owner?.lifecycle?.removeObserver(lifecycleObserver)
    }
    fun notifyChange(lifecycleObserver: LiveDataLifeCycleObserver){
        lifecycleObserver.observer.invoke(mValue);
    }

    //to give callback on attaching a observer, to remove observer automatically if observer is destroyed
    inner class LiveDataLifeCycleObserver(val owner: LifecycleOwner, val observer: (T?) -> Unit): LifecycleObserver{


        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private fun onStarted() {
            notifyChange(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        private fun onResumed() {
            notifyChange(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        private fun onDestroyed() {
            removeObserver(observer)
        }
    }
}
package com.example.myapplication.mvvmlivedata.view.vm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent


class SimpleCustomLiveData<T>{
    private var mValue: T? = null


    //(T?) -> Unit is a function type which denotes that our observers must be
    // lambda expressions which take one argument T? and returns Unit.
    private val mObserver = HashMap<(T?) -> Unit, LifecycleOwner>()

    // from activity, we call viewModel.observe(this, Observer {
    // // code
    // })
    // so this is LifeCycleOwner of observer,
    fun observe(owner: LifecycleOwner, observer: (T?) -> Unit){
        mObserver.put(observer, owner);
    }


    fun setValue(value: T){
        mValue = value

        //iterating all key value pairs (all observers)
        for((observer, owner) in mObserver){
            if(owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
                observer.invoke(mValue)
            }
        }
    }

    fun getValue(): T?{
        return mValue
    }

    fun removeObserver(observer: (T?) -> Unit){
        mObserver.remove(observer)
    }


    /**
     * But! What about removing observers from the LiveData when their UI components are destroyed?
     * And what about passing the current value to the observers immediately after they are attached
     * to the LiveData?
     *
     * hence we monitor the lifecycle associated with the observers.
     * Till now we haven't monitored the lifecycle of observer. We just kept a check on observer owner started or not
     */
}

class CustomLiveData<T> {

    //basic setters for a variable
    private var mValue: T? = null

    //can have any number of observers, hence list
//    private val mObservers = HashMap<(T?) -> Unit, LifecycleOwner>()
    private val mObservers = HashMap<(T?) -> Unit, LiveDataLifeCycleObserver>()
    
    fun setValue(value: T) {
        mValue = value

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

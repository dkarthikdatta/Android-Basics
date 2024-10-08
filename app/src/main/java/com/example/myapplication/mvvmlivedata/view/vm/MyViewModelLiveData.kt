package com.example.myapplication.mvvmlivedata.view.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
* Livedata -> observable dataholder.
* if there are any changes in LiveData, a callback is automatically made
* LiveData -> LifeCycle Aware -> notifies only to active components
 *
 *
 *  MutableLiveData -> data can be changed
 *  LiveData -> read only
 */

class MyViewModelLiveData: ViewModel() {
    /**
     * this is using mutableLiveData. But this is not preferable as factsData can be modified from anywhere
    val factsLiveData = MutableLiveData<String>("This is a fact")

    fun updateFactsData(){
        factsLiveData.value = "Data Changed / Update"
    }
     */
    private val factsLiveDataObject = SingleLiveEvent<String>()

    // here, instead of observing directly on MutableLiveData object,
    // we are accessing/ observing on LiveData (non mutable), which again observes MutableLiveData by getter property
    val factsLiveData: LiveData<String>
        get() = factsLiveDataObject


    /**
     * using SingleLiveEvent, we get update only on explicitly calling setValue
     * not on rotation change
     */
    private val toastMsg = SingleLiveEvent<String>()
    val getToastMsg: SingleLiveEvent<String>
        get() = toastMsg

    fun updateFactsData(){
         factsLiveDataObject.setValue("Data Changed / Update")
    }

    fun onToastClicked() {
        toastMsg.setValue("You are seeing a toast")
    }

}
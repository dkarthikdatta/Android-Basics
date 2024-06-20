package com.example.myapplication.coroutines.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.coroutines.ApiCall
import com.example.myapplication.mvvmlivedata.view.vm.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 * Coroutines are just like threads but not threads actually (called as light weight threads)
 * coroutines run on the top of threads -> framework over threads which automatically shifts threads
 *
 * Coroutines Scope -> defines lifetime
 * Coroutines Context -> defines to run on which thread
 * Dispatchers -> IO, Main, Default
 * Dispatchers -> Dispatch on which thread pool
 */

class MyCRViewModel : ViewModel() {
    private val TAG = "COROUTINES_LEARN "
    private val apiCall: ApiCall = ApiCall()
    private val apiResponse: SingleLiveEvent<String> = SingleLiveEvent()

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            while (true) {
//                delay(500)
//                println(TAG + "Hello from ViewModel, inside coroutine")
//            }
//        }
//    }

    val getApiResponse: LiveData<String>
        get() = apiResponse

    fun makeApiCall() {
        viewModelScope.launch {
            apiResponse.setValue(apiCall.getApiResponse())
        }
    }

    override fun onCleared() {
        super.onCleared()
        println(TAG + "View model destroyed")
    }
}
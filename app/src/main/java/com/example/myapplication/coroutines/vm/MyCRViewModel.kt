package com.example.myapplication.coroutines.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class MyCRViewModel : ViewModel(){
    private val TAG = "COROUTINES_LEARN "

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true){
                delay(500)
                println(TAG + "Hello from ViewModel, inside coroutine")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        println(TAG + "View model destroyed")
    }
}
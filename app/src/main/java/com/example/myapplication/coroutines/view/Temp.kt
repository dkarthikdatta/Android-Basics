package com.example.myapplication.coroutines.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

fun main() {
    val temp = Temp()
    temp.runFun()
}

class Temp : ViewModel() {


    val TAG = "Hello"

    fun runFun() {
//        val supervisorJob = SupervisorJob()
//        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
//            println(throwable.message)
//        }
//        viewModelScope.launch(Dispatchers.IO + supervisorJob + errorHandler) {
//
//        }
//        CoroutineScope(Dispatchers.IO + supervisorJob + errorHandler).launch {
//
//        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                launch {
                    try {
                        println("in child")
                        throw Exception("custom exception in child")
                    } catch (e: Exception) {
                        println(TAG + "in child catch exception " + e.localizedMessage)
                    }
                }
            } catch (e: Exception) {
                println(TAG + "in catch exception " + e.localizedMessage)
            } finally {
                println(TAG + "in finally block")
            }
        }

    }
}
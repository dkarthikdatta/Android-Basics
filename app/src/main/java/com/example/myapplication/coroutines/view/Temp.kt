package com.example.myapplication.coroutines.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main() {
    val temp = Temp()
    runBlocking {
        temp.runCancellationThings()
    }
}

class Temp : ViewModel() {


    val TAG = "Hello"

    suspend fun runCancellationThings() {

        val job = CoroutineScope(Dispatchers.IO).launch {
            try {
                repeat(1000000) { i ->
//                    if(isActive){
                        println("Job: I'm running fib $i .. ")
//                    }
                }
            } catch (e: CancellationException) {
                println("Job was cancelled")
            } finally {
                println("Job is finishing")
            }
        }
        // Cancels the job after 1300ms
        delay(100)
        job.cancel()
        println("Main: Now I can quit.")


    }

    private suspend fun fib(x: Int): Int {
        if (x <= 0) {
            return 0
        }
        if (x == 1) {
            return 1
        }
        return fib(x - 1) + fib(x - 2)
    }

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
//package com.example.myapplication.kotlin
//
//import kotlinx.coroutines.delay
//
//
//interface Callback {
//    fun onSuccess(result: String)
//    fun onFailure(error: Throwable)
//}
//
//fun fetchData(callback: Callback) {
//    // Simulating an asynchronous operation
//    Thread {
//        try {
//            // Perform a long-running operation
//            val processedData = processData()
//            callback.onSuccess(processedData)
//        } catch (e: Exception) {
//            callback.onFailure(e)
//        }
//    }.start()
//}
//
//fun processData(): String {
//    Thread.sleep(1000)
//    return "processed-data"
//}
//
//suspend fun fetchData(): Result {
//
//}
//class Sample {
//
//}

package com.example.myapplication

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


/**
 * 1. can i create coroutines in normal function or should it be in suspend function?
 * coroutine can be launched from normal function. the suspend functions like other our
 * own custom written suspend functions or delay (system suspend functions) should not be called from normal function
 *
 * call suspend function from a coroutine or other suspend function
 */
//fun main() {
//
//    CoroutineScope(Dispatchers.IO).launch {
//        println("inside coroutine, first line")
//        delay(100)
//        println("after coroutine, first line")
//    }
//     // above code cant run because launch is fire and forget. the main function completes immediately after launch
//}

/**
 * 2. Types of coroutine builders
 *      1. launch - fire and forget
 *      2. async - returns a deferred object. await is used to get result. code after await doesn't run until result is available
 *      3. withContext - similar as async, but doesn't create a new coroutine. just changes the context. hence it is suspend function unlike launch and async
 *      4. runBlocking - blocks the thread which it is running on
 */
//suspend fun main() {
//    // may run and may not run as launch is fire and forget. if this coroutines takes time than the main function execution, all code wont run
//    CoroutineScope(Dispatchers.IO).launch {
//        println("hello, inside launch, before, current thread = ${Thread.currentThread().name}")
//        delay(100)
//        println("hello, inside launch, after, current thread = ${Thread.currentThread().name}")
//    }
//
//    // able to call suspend function - withContext, the suspend function (which is not coroutine) as main is suspend function
//    withContext(Dispatchers.Default) {
//        delay(100)
//        println("hello, inside independent withContext, current thread = ${Thread.currentThread().name}")
//    }
//
//    val job = CoroutineScope(Dispatchers.IO).async {
//        println("hello, before withContext, current thread = ${Thread.currentThread().name}")
//        // able to call suspend function - withContext (which is not coroutine) as main is suspend function
//        withContext(Dispatchers.Default) {
//            delay(1000)
//            println("hello, inside withContext, current thread = ${Thread.currentThread().name}")
//        }
//        println("hello, after withContext, print only after above, current thread = ${Thread.currentThread().name}")
//    }
//    job.await()
//    println("hello, after async job, print only after above, current thread = ${Thread.currentThread().name}")
//
//}


/**
 * blocking function -> which takes time to get the result and affects the perf thread it is in
 * suspend function -> any function with suspend key word
 *
 * calling blocking code in
 * a. proper suspend function like withContext(Dispatcher.IO) or
 * b. coroutine
 * -> which takes time to get the result but DOESN'T affects the perf thread it is in
 *
 * shift the context (withContext) only where the actual blocking code is present (lowest level)
 * no need to do in all suspend functions.
 *
 * MainSafety -> calling suspend function without affecting main thread perf
 */

fun main() {
    runBlocking {

    }
}
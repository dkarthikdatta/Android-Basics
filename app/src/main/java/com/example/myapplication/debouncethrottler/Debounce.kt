package com.example.myapplication.debouncethrottler

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Debounce {
    val TAG = " DEBOUNCE "
    private var debounceJob: Job? = null
    fun <T> debounce(
        waitMs: Long = 300L,
        scope: CoroutineScope,
        destFunction: (T) -> Unit
    ): (T) -> Unit {
        var debounceJob: Job? = null
        return { param: T ->
            debounceJob?.cancel()
            debounceJob = scope.launch {
                delay(waitMs)
                destFunction(param)
            }
        }
    }

    fun <T> throttleLatest(
        intervalMs: Long = 300L,
        coroutineScope: CoroutineScope,
        destinationFunction: (T) -> Unit
    ): (T) -> Unit {
        var throttleJob: Job? = null
        var latestParam: T
        return { param: T ->
            latestParam = param
            if (throttleJob?.isCompleted != false) {
                throttleJob = coroutineScope.launch {
                    delay(intervalMs)
                    latestParam.let(destinationFunction)
                }
            }
        }
    }

    fun <T> throttleFirst(
        skipMs: Long = 300L,
        coroutineScope: CoroutineScope,
        destinationFunction: (T) -> Unit
    ): (T) -> Unit {
        var throttleJob: Job? = null
        return { param: T ->
            if (throttleJob?.isCompleted != false) {
                throttleJob = coroutineScope.launch {
                    destinationFunction(param)
                    delay(skipMs)
                }
            }
        }
    }

    var count = 0;
//    fun <T> debounce(delayMs: Long = 500L,
//                     coroutineContext: CoroutineContext,
//                     f: (T) -> Unit): (T) -> Unit {
//
//        var debounceJob: Job? = null
//        count++
//        System.out.println("outside return calling debounce: " + count.toString() + " time/s. debounceJob instance = " + debounceJob.toString())
//        return { param: T ->
//            System.out.println("inside return, outside if,  calling debounce: " + count.toString() + " time/s. debounceJob instance = " + debounceJob.toString())
//            if (debounceJob?.isCompleted != false) {
//                System.out.println("inside return, if start,  calling debounce: " + count.toString() + " time/s. debounceJob instance = " + debounceJob.toString())
//                debounceJob = CoroutineScope(coroutineContext).launch {
//                    delay(delayMs)
//                    f(param)
//                    System.out.println("inside return, inside job,  calling debounce: " + count.toString() + " time/s. debounceJob instance = " + debounceJob.toString())
//                }
//                System.out.println("inside return, if end,  calling debounce: " + count.toString() + " time/s. debounceJob instance = " + debounceJob.toString())
//            }
//        }
//    }
}
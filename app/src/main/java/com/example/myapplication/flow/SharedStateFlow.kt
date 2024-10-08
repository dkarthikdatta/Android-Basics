package com.example.myapplication.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Both Shared flow and State flow are hot flows
 *
 *
 * 1. Shared flow
 *          1. Hot Flow
 *          2. Does not need an initial value so does not emit any value by default.
 *          3. Can be configured to emit many previous values using the replay operator.
 *          4. It emits all the values and does not care about the distinct from the previous item. It emits consecutive repeated values also.
 *          5. Not similar to LiveData
 */

fun sharedFlow(): SharedFlow<Int> {
    val sharedFlow = MutableSharedFlow<Int>()
    CoroutineScope(Dispatchers.IO).launch {// need to start a coroutine here because flow is not creating a coroutine. if we don't use a coroutine, the emits will be done on the same thread and blocks and collect is after this calling function hence no collection happens
        (1..10).forEach {
            delay(100)
            sharedFlow.emit(it)
        }
        sharedFlow.emit(10)
        sharedFlow.emit(10)
    }
    return sharedFlow
}

suspend fun main() {
//    val startSharedFlow = sharedFlow()
//    delay(300)  // data is lost due to delay
//    startSharedFlow.collect {
//        println(it)
//    }

    val startStateFlow = stateFlow()
    delay(500)
    startStateFlow.collect {
        println(it)
    }
}

/**
 * 2. State flow
 *      1. Hot Flow
 *      2. Needs an initial value and emits it as soon as the collector starts collecting.
 *      3. Only emits the last known value.
 *      4. It does not emit consecutive repeated values. It emits the value only when it is distinct from the previous item.
 *      5. Similar to LiveData except for the Lifecycle awareness of the Android component. We should use repeatOnLifecycle scope with StateFlow to add the Lifecycle awareness to it, then it will become exactly like LiveData.
 */

fun stateFlow(): StateFlow<Int> {
    val stateFlow = MutableStateFlow<Int>(0)
    CoroutineScope(Dispatchers.IO).launch {
        (1..15).forEach {
            delay(100)
            stateFlow.emit(it)
        }
        stateFlow.emit(15)
        stateFlow.emit(15)
    }
    return stateFlow
}

class SharedStateFlow {

}
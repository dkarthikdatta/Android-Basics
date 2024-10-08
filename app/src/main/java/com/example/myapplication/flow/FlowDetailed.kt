package com.example.myapplication.flo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce

/**
 *
 * A Flow is similar to coroutines in that it is built on top of Kotlin coroutines
 *
 * 1. Flow Builder
 * 2. Operator
 * 3. Collector
 */

/**
 * 1. simple flow example
 */
//suspend fun main() {
//    flow<Int> { // flow builder. this is like coroutine. build a coroutine
//        (0..10).forEach {
//            emit(it)
//        }
//    }.map {
//        delay(1000)      //operator
//        it*it
//    }.collect {         // collector. collect is  a suspend function
//        println(it)
//    }
//}

/**
 * 2. 4 types of Flow Builder
 *
 * 1. flowOf() - It is used to create flow from a given set of items.
 * 2. asFlow() - It is an extension function that helps to convert type into flows
 * 3. flow{} - to emit
 * 4. channelFlow{} - using send provided by the builder itself.
 */
//suspend fun main() {
//    //1
////    flowOf(2,3,4)
////        .collect {
////        println(it)
////    }
//
//    //2
////    (1..5).asFlow()
////        .collect{
////            println(it)
////        }
//
//    //3
////    flow<Int> {
////        (1..7).forEach {
////            emit(it)
////        }
////    }.collect {
////        println(it)
////    }
//
//    //4
//    channelFlow<Int> {
//        (0..10).forEach {
//            send(it)
//        }
//    }
//        .collect {
//            println(it)
//        }
//}

/**
 * 3. Operators
 *
 * flowOn is also operator apart from map, filter, reduce etc
 *
 */

//suspend fun main() {
//    val resultingFlow: Flow<Int> = doSomeTaskWithDelay()
//
//    /**
//     * in coroutines,
//     * in launch builder, if we are not concerned about result inside coroutine,
//     * we just care about which context we are launching in.
//     * but if we want to have result of something in coroutine (like api response),
//     * then we take that response and return in proper dispatcher (context - like main)
//     *
//     * in flow, since we always get some result, we need to care on which context we need to collect result
//     */
//
////    resultingFlow.collect {
////        println(it)
////    }
//
//    // map and filter
////    flow<Int> {
////        (1..10).forEach {
////            emit(it)
////        }
////    }.filter {
////        it % 2 == 0
////    }.map {
////        it*it
////    }.collect{
////        println(it)
////    }
//
//    // reduce -> returns a type of datastructure. not flow
//    // apply a function to each item emitted and emit the final value
//
//    val reduceFlow = flow<Int> {
//        (1..10).forEach {
//            emit(it)
//        }
//    }.reduce { accumulator, value ->
//        accumulator + value
//    }
//    println(reduceFlow)
//}

fun doSomeTaskWithDelay(): Flow<Int> {
    val currFlow = flow<Int> {
        (1..10).forEach {
            delay(1000) // long task
            emit(it)
        }
    }.flowOn(Dispatchers.Default) // just like coroutines, need to switch the context based on requirement after building flow
    return currFlow

}

/**
 * 4. Cold flow vs Hot Flow
 *
 * a.
 * Cold flow - it emits data only when there is a collector.
 * Hot flow - It emits data even when there is no collector.
 *
 * Cold flow - It does not store data.
 * Hot flow - It can store data.
 *
 * Cold flow - It can't have multiple collectors.
 * Hot flow - It can have multiple collectors.
 *
 */

suspend fun main() {

    // by default normal flow is cold flow
    // StateFlow and SharedFlow are Hot Flows.

//    val flowExample = flow<Int> {
//        (1..10).forEach {
//
//            emit(it)
//        }
//    }
//
//    delay(3000)
//    flowExample.collect {
//        println(it) // code inside collect runs for each item collected
//    }

    // a. Cold flow - it emits data only when there is a collector.

}

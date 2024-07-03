package com.example.myapplication.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

suspend fun main() {
    val data = flowProducer()
    data.collect {
        println(it)
    }
}

fun flowProducer(): Flow<Int> {
    val myFlow = flow<Int> {
        repeat(3) {
            emit(it * 100)
        }
    }
    return myFlow
}

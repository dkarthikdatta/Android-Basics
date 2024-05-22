package com.example.myapplication.flow

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * coroutines -> suspend function returns only a single object
 * to get the streaming data we use flow/channel.
 *
 * channels -> send and receive -> hot (producers produce irrespective of consumers) - radio - produces even if client is not listening. movie. data is lost if not consumed
 * flows -> emit and collect -> cold (producers only produce if there are consumers) - netflix movie - pause. play -> produces only after play button is clicked. data is consumed only from start
 */

val channel: Channel<Int> = Channel()
fun main() {
    runBlocking {

//        val job = CoroutineScope(Dispatchers.IO).async {
//            getUserName().forEach {
//                println(
//                    FlowActivity.TAG +
//                            it
//                ) // this getUserName() func needs to wait till all 4 users are added in the list with 1000 * 4 ms delay
//            }
//        }
//
//        job.await()

        channelProducer()
        channelConsumer()

    }

}

fun channelConsumer() {
    CoroutineScope(Dispatchers.IO).launch {
        println(FlowActivity.TAG + channel.receive().toString())
        println(FlowActivity.TAG + channel.receive().toString())
        println(FlowActivity.TAG + channel.receive().toString())
    }
}

fun channelProducer() {
    CoroutineScope(Dispatchers.IO).launch {
        channel.send(1)
        channel.send(2)
        channel.send(3)
    }
}

private suspend fun getUserName(): List<String> {
    val list = mutableListOf<String>()
    list.add(getUserFromAPI(1))
    list.add(getUserFromAPI(2))
    list.add(getUserFromAPI(3))
    list.add(getUserFromAPI(4))
    return list
}

private suspend fun getUserFromAPI(id: Int): String {
    delay(1000) // API call delay
    return "User$id"
}
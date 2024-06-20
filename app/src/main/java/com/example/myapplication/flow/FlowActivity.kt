package com.example.myapplication.flow

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * coroutines -> suspend function returns only a single object
 * to get the streaming data we use flow/channel.
 *
 * channels -> send and receive -> hot (producers produce irrespective of consumers) - radio - produces even if client is not listening. movie. data is lost if not consumed
 * flows -> emit and collect -> cold (producers only produce if there are consumers) - netflix movie - pause. play -> produces only after play button is clicked. data is consumed only from start
 */
class FlowActivity : AppCompatActivity() {

    val channel = Channel<Int>()

    companion object {
        const val TAG = "FLOW"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        //normal suspend (single object return) case
//        CoroutineScope(Dispatchers.IO).launch {
//            getUserName().forEach {
//                Log.d(
//                    TAG,
//                    it
//                ) // this getUserName() func needs to wait till all 4 users are added in the list with 1000 * 4 ms delay
//            }
//        }

        // only these 2 are discussed in channels
        channelProducer()
        channelConsumer()

//        // flow
        val job = GlobalScope.launch {
            val data = flowProducer()
            data.collect {
                Log.d(TAG, it.toString())
            }
        }
//
//        //to cancel a flow, just stop consuming the flow.
//        // flow automatically stops producing
//        GlobalScope.launch {
//            delay(3500)
//            job.cancel()
//        }

//
//        GlobalScope.launch {
//            val data = flowProducer()
//            data.collect {
//                Log.d(TAG + " First Flow", it.toString())
//            }
//        }
//
//        // even there is delay in consuming flow,
//        // the flow is consumed from the beginning by all consumers
//        // data is not lost
//
//        GlobalScope.launch {
//            val data = flowProducer()
//            delay(3000)
//            data.collect {
//                Log.d(TAG + " Second Flow", it.toString())
//            }
//        }

//        GlobalScope.launch {
//            val data = flowProducer()
//            data.onStart {
//                emit(-1)    // manually emitting
//                Log.d(TAG, "Starting")
//            }.onCompletion {
//                Log.d(TAG, "onComplete")
//            }.collect {
//                Log.d(TAG, it.toString())
//            }
//        }

//        //terminal operators
//        GlobalScope.launch {
//            val data = flowProducer()
//            val first = data.first()
//            val allItems = data.toList()
//        }
//
//        //non terminal operators
//        GlobalScope.launch {
//            val data = flowProducer()
//            data.map {
//                it*2
//            }.filter {
//                it<8
//            }.collect{
//                Log.d(TAG, it.toString())
//            }
//        }

        /**
         * producer is producing each element at 1000ms each
         * but consumer is consuming each element in 1500 due to some operations while consuming
         * hence bottleneck at consumer
         * buffer at consumer with a capacity
         */
//        GlobalScope.launch {
//            val data = flowProducer()
//            val ms = measureTimeMillis {
//                data.buffer(3)
//                    .collect {
//                        delay(1500)
//                        Log.d(TAG, it.toString())
//                    }
//            }
//        }

        // use flowOn to specify where producer should run
        // all calls before flowOn (producer, map, filter) are runned in that context only

//        GlobalScope.launch {
//            val data = flowProducer()
//            data.map {
//                it * 4
//            }.flowOn(Dispatchers.IO)
//                .buffer(3)
//                .collect {
//                    delay(1500)
//                    Log.d(TAG, it.toString())
//                }
//        }
//
//        GlobalScope.launch {
//            val result = sharedProducer()
//            result.collect{
//                Log.d(TAG, it.toString())
//            }
//        }
//
//        // shared flow -> making flow as hot nature
//        // shared flow, if delay in consuming, data is lost
//        GlobalScope.launch {
//            val result = sharedProducer()
//            delay(2500)
//            result.collect{
//                Log.d(TAG, it.toString())
//            }
//        }
//
        //state flow
        GlobalScope.launch {
            val result = stateProducer()
            delay(6000) // even there is delay of 6000ms, since stateFlow is hot nature, all data is lost that are emitted before 6000ms. but last value in the producer is emitted - state maintained
            result.collect{
                Log.d(TAG, it.toString())
            }
        }

    }

    //by default, flow is suspend func
    private fun flowProducer() = flow<Int> {
        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            delay(1000) // api delay
            emit(it)
        }

    }

    // producing flow on IO coroutine.
    // this causes crash as producing on IO thread
    // and consuming in main thread
    // while consuming, use flowOn to specify where the producer should run

    private fun flowProducer1() = flow<Int> {
        withContext(Dispatchers.IO) {
            val list = listOf(1, 2, 3, 4, 5)
            list.forEach {
                delay(1000) // api delay
                emit(it)
            }
        }
    }

    private fun flowProducer2() = flow<Int> {
        val list = listOf(1, 2, 3, 4, 5)
        list.forEach {
            delay(1000) // api delay
            emit(it)
        }
    }.catch {
        Log.d(TAG, it.message ?: "error in producer")
        emit(-1) //emit if required in error
    }

    // sharedFlow - like hot flows. same data is shared. data is lost if not consumed
    //
    private fun sharedProducer(): Flow<Int> {
        val mutableSharedFlow = MutableSharedFlow<Int>()
        GlobalScope.launch {
            val list = listOf(1, 2, 3, 4)
            list.forEach {
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
    }

    // state flow -> similar to shareFlow. -> hot, multiple consumers
    // maintains state, last value is retained (like single buffer) and emits last value to consumer irrespective of how late the consumer is consuming

    private fun stateProducer(): Flow<Int> {
        val mutableStateFlow = MutableStateFlow(10)// init value
        GlobalScope.launch {
            val list = listOf(1, 2, 3, 4)
            list.forEach {
                mutableStateFlow.emit(it)
                delay(1000)
            }
        }
        return mutableStateFlow
    }


    private fun channelProducer() {
        CoroutineScope(Dispatchers.IO).launch {
            channel.send(1)
            channel.send(2)
        }
    }

    private fun channelConsumer() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d(TAG, channel.receive().toString())
            Log.d(TAG, channel.receive().toString())
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
}


package com.example.myapplication.handlerlooper

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Objects

//
//fun main() {
//
//}
//
//
//class Print {
//    var count = 1;
//    var N = 0;
//
//    fun printEven(){
//        synchronized(this){
//            while (count<N){
//                while (count%2==1){
//                    try {
//                        (this as Object).wait()
//                    } catch (e: Exception){
//                        Log.d("TAG", e.message ?: "")
//                    }
//                }
//            }
//        }
//    }
//}


class MyClass1 {
    var count = 1
    val lock = Object()
    fun printOddNumber() {
        synchronized(lock) {
            while (count < N) {
                while (count % 2 == 0) {
                    try {
                        lock.wait()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                print("$count ")
                count++
                lock.notify()
            }
        }
    }

    fun printEvenNumber() {
        synchronized(lock) {
            while (count < N) {
                while (count % 2 == 1) {
                    try {
                        lock.wait()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                print("$count ")
                count++
                lock.notify()
            }
        }
    }

    companion object {
        var N = 0
        @JvmStatic
        fun main(args: Array<String>) {
//            N = 10
//            val myClass = MyClass1()
//            val t1 = Thread { myClass.printEvenNumber() }
//            val t2 = Thread { myClass.printOddNumber() }
//            t1.start()
//            t2.start()

            val oddEvenCor = OddEvenCor()
            oddEvenCor.runFunc()
        }
    }
}

class OddEvenCor {
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun runFunc(){
        runBlocking {
            val job2 = coroutineScope.launch { printOdd() }
            val job1 = coroutineScope.launch { printEven() }
            job1.join()
            job2.join()
        }
    }


    suspend fun printEven(){
        for(i in 2..10 step 2){
            println("even no: "+ i)
//            delay(10)
        }
    }
    suspend fun printOdd(){
        for(i in 1..10 step 2){
            println("odd no: "+ i)
 //           delay(10)
        }
    }
}
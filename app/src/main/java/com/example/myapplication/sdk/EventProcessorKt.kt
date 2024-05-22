package com.example.myapplication.sdk

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.util.Random
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class EventProcessorKt(private val myDb: MyDb) {
    //    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
//    var executor = ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, LinkedBlockingQueue())
    fun processEvent(student: Student?, id: Int) {
        println("MYSDK added task to q before executing, id - $id")
        CoroutineScope(Dispatchers.IO).launch {
//            executor.execute {
            println("MYSDK added task to q after executing")
//                val q = executor.queue
//                println("MYSDK Blocking q items " + q.size)
            println("MYSDK making extensive operations")
            val veryBig = BigInteger(100, Random())
            veryBig.nextProbablePrime()

//            try {
//                Thread.sleep(1000); // making some operations
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            if (myDb.allStudentList.size < 25) {
                myDb.addStudent(student)
            } else {
                // making api call
                println("MYSDK making an api call")
                val veryBig2 = BigInteger(10000, Random())
                veryBig2.nextProbablePrime()

//                try {
//                    System.out.println("MYSDK making an api call");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                myDb.deleteAllStudents()
            }
        }
    }
}

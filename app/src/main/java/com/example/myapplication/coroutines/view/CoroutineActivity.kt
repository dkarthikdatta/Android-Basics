package com.example.myapplication.coroutines.view

import android.net.http.HttpException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.coroutines.vm.MyCRViewModel
import com.example.myapplication.databinding.ActivityThirdBinding
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.net.HttpRetryException


/**
 *
 * Coroutines are just like threads but not threads actually (called as light weight threads)
 * coroutines run on the top of threads -> framework over threads which automatically shifts threads
 *
 * Coroutines Scope -> defines lifetime
 * Coroutines Context -> defines to run on which thread -> Dispatchers
 * Dispatchers -> IO, Main, Default
 * Dispatchers -> Dispatch on which thread pool
 */


/**
 * 1. job vs supervisor job in coroutines
 * 2. if all my IO threads are used in coroutines, and there are still IO dispatcher tasks, will Default threads get be used as IO?
 * 3. how many threads are allocated to Dispatcher Default coroutine and Dispatcher IO
 */

class CoroutineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private lateinit var viewModel: MyCRViewModel
    private val TAG = "COROUTINES_LEARN "
//    private lateinit var viewModel: MyCRViewModel
    /**
     * todo: read about scope of coroutine
     */
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyCRViewModel::class.java)
        /**
         * viewModeScope and lifecycleScope coroutines.
         * Coroutines in viewModelScope are destroyed when viewModel is destroyed
         */
//        viewModel = ViewModelProvider(this).get(MyCRViewModel::class.java)
//        lifecycleScope.launch {
//            delay(5000)
//            startActivity(Intent(this@ThirdActivity, MainActivity::class.java))
//            finish()
//        }

        viewModel.getApiResponse.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })


        binding.btn.setOnClickListener {
//            viewModel.makeApiCall()

            //imp
            CoroutineScope(Dispatchers.IO).launch {
                System.out.println("CoroutineScope, IO Dispatcher " + Thread.currentThread().name)
            }

            GlobalScope.launch {
                System.out.println("GlobalScope, No Dispatcher " + Thread.currentThread().name)
            }
            MainScope().launch {
                System.out.println("MainScope, No Dispatcher " + Thread.currentThread().name)
            }


            // suspend -> suspends func/coro to diff thread
            // call from cor or another suspend function


            /**
             * 1.
             *  output of below 2 lines
             *  COROUTINES_LEARN Starting Task 1 - start
             *  COROUTINES_LEARN Starting Task 2 - No delay
             *  COROUTINES_LEARN Ending Task 1 - 10 seconds after
             *  COROUTINES_LEARN Ending Task 2 - no delay (as same 10 seconds time taken)
             */

            CoroutineScope(Dispatchers.IO).launch {
                task1()
            }
            CoroutineScope(Dispatchers.IO).launch {
                task2()
            }

            /**
             * 2.
             *  output of below 2 lines
             *  COROUTINES_LEARN Starting Task 1 - start
             *  COROUTINES_LEARN Ending Task 1 - 10 seconds
             *  COROUTINES_LEARN Starting Task 2 - immediate
             *  COROUTINES_LEARN Ending Task 2 - 10 seconds
             *
             *  tasks inside one coroutine runs in sequence, regardless of whether they are suspend or not and  suspension points are available or not
             *
             *  suspend functions/normal functions/lines of code inside coroutines execute in sequence
             *  coroutines inside coroutines execute concurrently
             */
//
//            CoroutineScope(Dispatchers.IO).launch {
//                task1()
//                task2()
//            }

            /**
             * spl
             *
             */

//            CoroutineScope(Dispatchers.IO).launch{
//                println("I want to print")
//                val data = prepareData()
//                println("data: " + data )
//                println("I want to print2")
//            }

            /**
             * 3.
             * Coroutines Builder ->> launch, async -> returns job
             */
            CoroutineScope(Dispatchers.IO).launch {
                printFollowers()
            }
        }
    }

    suspend fun prepareData(): List<Song> {
        println("in prepareData of DataRepository")
        return getData()
    }

    suspend fun getData(): List<Song> {
        println("Helloooo")
        delay(10)
//        val json =
//            File("/Users/karthikdatta/Desktop/Repos/Learn/app/src/main/java/com/example/myapplication/machinecoding/musicsimilarsuggestion/models/data.json").readText()
//        val gson = Gson()
//        val songListType = object : TypeToken<List<Song>>() {}.type
//        val data = gson.fromJson<List<Song>>(json, songListType)
        val data = listOf<Song>(Song(1, "telugu", "one", 12, null))
        println(data)
        return data
    }


    private suspend fun task1() {
        println(TAG + "Starting Task 1")
        delay(1000) // any long running task like api call that is called withContext-actual suspension point
        println(TAG + "Ending Task 1")
    }

    private suspend fun task2() {
        println(TAG + "Starting Task 2")
        delay(1000) // any long running task like api call that is called withContext-actual suspension point
        println(TAG + "Ending Task 2")
    }

    private suspend fun printFollowers() {
        var followers = 0;
        /**
         * 4.
         * launch builder just builds the coroutines and changes into diff coroutine if there is an actual suspend point
         * but this does not ensure that if any result is returned from this coroutine is available before the execution of next line that is out of coroutine scope
         * in below coroutine, followers variable in println will be 0 as getFollowers() takes time and its built with launch builder
         * launch -> fire and forget
         */
        CoroutineScope(Dispatchers.IO).launch {
            followers = getFollowers()
        }
        println(TAG+ "4. Number of followers = "+ followers)

        /**
         * 5.
         * in below coroutine, followers will be 99 as print is inside the coroutine and code runs in sequence in one coroutine as discussed in 2
         * but it delays running for 5 seconds
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            followers = getFollowers()
//            println(TAG+ "5. Number of followers = "+ followers)
//        }

        /**
         * 6.
         * similar to 4, but how to ensure to print correct followers? wait until job is done
         * builders return an object called
         * job -> handle coroutine. start, wait, cancel
         */
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            followers = getFollowers()
//        }
//        job.join() // wait until this job is done. then only execute next lines
//        println(TAG+ "6. Number of followers = "+ followers)

        /**
         * 7.
         * async builder -> waits until result is returned -> returns a deferred object
         * returns whats there in the last line
         *
         * next lines of job.await() are not runned until the result of deffered object is available
         */

        val job2 = CoroutineScope(Dispatchers.IO).async {
            getFollowers()
        }
        println(TAG+ "I run immediate")
        println(TAG+ "7. Number of followers = "+ job2.await()) // waiting till job2 response is available
        println(TAG+ "I run only after above line")
        /**
         * 8.
         * more example of above using 2 coroutines
         * fb, insta parallel, but waits until both results are available
         */
        val fb = CoroutineScope(Dispatchers.IO).async {
            getFBFollowers()
        }
        val insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }
        println(TAG+ "8. Number of FB followers = "+ fb.await() + " Number of Insta followers = " + insta.await())

        /**
         * 9.
         * similar to 2, 5
         * both fb1 and insta1 runs in sequence as they are built in one coroutine
         *
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            val fb1 = getFBFollowers()
//            val insta1 = getInstaFollowers()
//            println(TAG+ "9. Number of FB followers = "+ fb1 + " Number of Insta followers = " + insta1)
//        }

        /**
         * 10.
         * Starting 2 coroutines using async. therefore fb2 and insta2 runs in parallel as they are separate coroutines
         * similar to 8
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            val fb2 = async { getFBFollowers() }
//            val insta2 = async { getInstaFollowers() }
//            println(TAG+ "10. Number of FB followers = "+ fb2.await() + " Number of Insta followers = " + insta2.await())
//        }

        /**
         * 11.
         * more about parent child coroutines
         * context of child coroutine is same as parent coroutine unless overrided.
         *
         * IMPORTANT
         *
         * This creates new coroutine and its NOT child of the parent
         * val child = CoroutineScope(Dispatchers.Default).launch {
         * }
         * this is not actually a child of the outer parentJob2, even though it is inside the same coroutine. Instead, it is a child of the new scope created with CoroutineScope(Dispatchers.IO).
         *
         * just starting coroutine with launch makes it child of parent.
         * if you want to change the context of child, you can change using syntax launch(Dispatchers.Main){}
         * child = launch{
         * //
         * }
         *
         */
//        val parentJob = CoroutineScope(Dispatchers.IO).launch {
//            println(TAG+ "11. Parent coroutine context is: " + coroutineContext)
//            val childJob = launch(Dispatchers.Main) {
//                println(TAG+ "11. Child coroutine context is: " + coroutineContext)
//            }
//        }

        /**
         * 12.
         * Parent coroutine completes only after all work is done in child coroutines
         * below ex, even though parent ends in 3s, it actually completes after 5s i.e., after child ends
         *
         * // check job cancel for long running task. have to keep check isActive inside coroutine even though job.cancel is called.
         */

//        val parentJob2 = CoroutineScope(Dispatchers.IO).launch {
//            println(TAG + "12. Parent Job started")
//            val childJob2 = launch {
//                println(TAG + "12. Child Job started")
//                delay(5000)
//                println(TAG + "12. Child Job ended")
//            }
//            delay(3000)
//            println(TAG + "12. Parent Job ended")
//        }
//
////        delay(1000)
////        parentJob2.cancel() // cancels parentJob execution.
//        parentJob2.join() // waits until parentJob2 is completed. i.e., next line is runned only after parent job
//        println(TAG + "12. Parent Job completed")

        /**
         * 13.
         * withContext -> same as async -> waits for coroutines to complete work and wait for result
         * (blocking nature -> not blocking threads exactly. but waits for completion) -> next lines are runned only after completion of withContext block
         * withContext -> builds a coroutines, suspend function
         * used to easily represent the context switch context to IO dispatcher.
         */
//        var fb3: Int
//        withContext(Dispatchers.IO){
//            delay(5000)
//            fb3 = getFBFollowers()
//            println(TAG + "I am printing last line")
//        }
//        println(TAG + "13. FB followers: " + fb3)

        /**
         * 14. runBlocking
         * blocks thread until coroutines inside runBlocking.
         * ideally not used in android. just used in test cases.
         * cant be explained in Android studio. Intellij can be used/ test case env
         */

//        runBlocking {
//            launch {
//                delay(1000)
//                println(TAG + "14. Print Followers + "+getFBFollowers())
//            }
//            println(TAG + "14. After coroutine")
//        }

        /**
         * 15.
         * viewModelScope
         * lifeCycleScope -> (Activity/Fragment lifecycle)
         */


//        /**
//         * if job is cancelled, crash does not happens.
//         * if you want to catch, you can catch by try catch (for single coroutine) or exception handler
//         */
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            println("Started job")
//            delay(5000)
//            println("Ended job")
//        }
//        delay(1000)
//        job.cancel()

        /**
         * 16. Exceptional handling
         *
         * launch -> exception is caught immediately as soon as it is reached
         * async -> exception is not caught until await is called even though is is accumulated
         */

        /**
         * Exceptional handling
         * by Using try catch.
         * try catch works only for single coroutine
         * if there is exception in child coroutine and there is no try catch in child, then error propagates to parent but parent catch wont work
         */

        /**
         * try catch to single coroutine
         * this works perfectly as try catch is there for single coroutine
         */

//        val tryCatchJob = CoroutineScope(Dispatchers.IO).launch {
//            try {
//                println(TAG + "in try, start try job")
//                delay(2000)
//                throw Exception("custom exception")
//                println(TAG + "in try, printing after 2s")
//            } catch (e: Exception) {
//                println(TAG + "in catch exception " + e.localizedMessage)
//            } finally {
//                println(TAG + "in finally block")
//            }
//        }


        /**
         * try catch to child coroutine / multiple coroutines
         * this doesn't works and crashes as try catch is there for parent but not for child
         * the exception in the child propagates to parent (but not caught)
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                launch {
//                    println("in child")
//                    throw Exception("custom exception in child")
//                }
//            } catch (e: Exception) {
//                println(TAG + "in catch exception " + e.localizedMessage)
//            } finally {
//                println(TAG + "in finally block")
//            }
//        }

        /**
         * solutions -
         * 1. keep try catch in that particular coroutine (child) where exception may occur
         * 2. use exception handler -> Correct solution
         */

        // solution 1
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                launch {
//                    try {
//                        println("in child")
//                        throw Exception("custom exception in child")
//                    } catch (e: Exception) {
//                        println(TAG + e.localizedMessage)
//                    }
//                }
//            } catch (e: Exception) {
//                println(TAG + "in catch exception " + e.localizedMessage)
//            } finally {
//                println(TAG + "in finally block")
//            }
//        }

        //solution 2 - correct soln **** cancellation exceptions are not caught by this these are handled by default
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable)
        }
//        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            launch {
//                println("in child")
//                throw Exception("custom exception in child")
//            }
//        }

        /**
         * supervisorScope vs normal coroutine scope
         * same as
         * supervisorJob vs normal job
         *
         * error  propagates to child siblings if there is error in one child and cancels all jobs -> normal job
         * else supervisor job
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            launch {
//                delay(3000)
//                throw Exception(TAG + "Coroutine 1 failed") // crashes at 3s as no error handling
//            }
//            launch {
//                delay(5000)
//                println(TAG + "Coroutine 2 is done") // doesn't run as error at 3s in child 1-> error propagate
//            }
//        }
//
//        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            launch {
//                delay(3000)
//                throw Exception(TAG + "Coroutine 1 failed") // no crashes at 3s as error handling is done
//            }
//            launch {
//                delay(5000)
//                println(TAG + "Coroutine 2 is done") // doesn't run as error at 3s in child 1-> error propagate
//            }
//        }

        /**
         * by using supervisorScope / supervisorJob
         */

//        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            supervisorScope {
//                launch {
//                    delay(3000)
//                    throw Exception(TAG + "Coroutine 1 failed") // no crashes at 3s as error handling is done
//                }
//                launch {
//                    delay(5000)
//                    println(TAG + "Coroutine 2 is done") // run as error at 3s in child 1 doesn't propagates -> supervisor
//                }
//            }
//        }

        /**
         * using supervisorJob -> use at all places -> parent and child launchers
         */
//
//        val supervisorJob = SupervisorJob()
//
//        val parentJob = CoroutineScope(Dispatchers.IO + exceptionHandler + supervisorJob).launch {
//            launch(supervisorJob) {
//                delay(3000)
//                throw Exception(TAG + "Coroutine 1 failed") // no crashes at 3s as error handling is done
//            }
//            launch(supervisorJob) {
//                delay(5000)
//                println(TAG + "Coroutine 2 is done") // run as error at 3s in child 1 doesn't propagates -> supervisor
//            }
//        }

        /**
         * if using supervisorJob only for parent, child 2 does not print as
         *
         * Despite using SupervisorJob, the parent coroutine may still be in the process of handling
         * the exception and subsequently might complete before the second coroutine's delay finishes.
         * This results in the second coroutine getting cancelled before it can print its message.
         */
//
//        val supervisorJob2 = SupervisorJob()
//
//        val parentJob2 = CoroutineScope(Dispatchers.IO + exceptionHandler + supervisorJob2).launch {
//            launch() {
//                delay(3000)
//                throw Exception(TAG + "Coroutine 1 failed") // no crashes at 3s as error handling is done
//            }
//            launch() {
//                delay(5000)
//                println(TAG + "Coroutine 2 is done") // run as error at 3s in child 1 doesn't propagates -> supervisor
//            }
//        }

        //***********

        /**
         * if you cancel coroutine, it may run the code after try catch block because cancellation exception is caught by catch
         */

//        CoroutineScope(Dispatchers.IO).launch {
//            val child = launch {
//                try {
//                    delay(2000)
//                } catch (e: Exception){
//                    println(TAG + e.localizedMessage)
//                }
//                println("Coroutine 1 is finished") // prints even child is cancelled as error is not propgated properly
//            }
//            delay(1000)
//            child.cancel() // cancels after 1s
//        }

        /**
         * to cancel properly, throw exception explicitly if coroutine is cancelled
         * or catch specific exception instead of generic exception
         */

        // by catching specific exception
//        CoroutineScope(Dispatchers.IO).launch {
//            val child = launch {
//                try {
//                    delay(2000)
//                } catch (e: HttpRetryException) {
//                    println(TAG + e.localizedMessage)
//                }
//                println("Coroutine 1 is finished") // prints even child is cancelled as error is not propgated properly
//            }
//            delay(1000)
//            child.cancel() // cancels after 1s
//        }

        //throw exception explicitly if coroutine is cancelled
//        CoroutineScope(Dispatchers.IO).launch {
//            val child = launch {
//                try {
//                    delay(2000)
//                } catch (e: Exception) {
//                    if (e is CancellationException) {
//                        throw e
//                    }
//                    println(TAG + e.localizedMessage)
//                }
//                println("Coroutine 1 is finished") // prints even child is cancelled as error is not propgated properly
//            }
//            delay(1000)
//            child.cancel() // cancels after 1s
//        }


        /**
         * interview question
         */
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            try {
//                repeat(1000) { i ->
//                    println("Job: I'm sleeping $i ...")
//                    delay(500L)
//                }
//            } catch (e: CancellationException) {
//                println("Job was cancelled")
//            } finally {
//                println("Job is finishing")
//            }
//        }
//        // Cancels the job after 1300ms
//        delay(1300L)
//        job.cancelAndJoin()
//        println("Main: Now I can quit.")


        val job = CoroutineScope(Dispatchers.IO).launch {
            try {
                repeat(1000) { i ->
                    println("Job: I'm running $i ...")
                    delay(100)
                }
            } catch (e: CancellationException) {
                println("Job was cancelled")
            } finally {
                println("Job is finishing")
            }
        }
        // Cancels the job after 1300ms
        delay(1000)
        job.cancel()
        println("Main: Now I can quit.")

        /**
         * heavy calculations in coroutine which is getting cancelled
         */

//        val job = CoroutineScope(Dispatchers.IO).launch {
//            try {
//                repeat(40) { i ->
//                    println("Job: I'm running fib $i ... ${fib(i)}")
//                }
//            } catch (e: CancellationException) {
//                println("Job was cancelled")
//            } finally {
//                println("Job is finishing")
//            }
//        }
//        // Cancels the job after 1300ms
//        delay(1000)
//        job.cancel()
//        println("Main: Now I can quit.")


//        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
//            println("Exception caught in cancellationException: ${throwable.message}")
//        }
//        val job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            try {
//                println(TAG + "start job")
//                delay(2000)
//                println(TAG + "in try, printing after 2s")
//            } catch (e: Exception) {
//                println(TAG + "in try catch exception " + e.localizedMessage)
//            } finally {
//                println(TAG + "in finally block")
//            }
//
//        }
//        delay(1000)
//        job.cancel()
    }

    private suspend fun fib(x: Int): Int {
        if (x <= 0) {
            return 0
        }
        if (x == 1) {
            return 1
        }
        return fib(x - 1) + fib(x - 2)
    }

    private suspend fun getFollowers(): Int {
        delay(5000)
        return 99
    }

    private suspend fun getFBFollowers(): Int {
        delay(5000)
        return 82
    }

    private suspend fun getInstaFollowers(): Int {
        delay(5000)
        return 183
    }


}
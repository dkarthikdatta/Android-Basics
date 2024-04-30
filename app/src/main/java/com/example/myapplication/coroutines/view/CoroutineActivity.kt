package com.example.myapplication.coroutines.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityThirdBinding
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 *
 * Coroutines are just like threads but not threads actually (called as light weight threads)
 * coroutines run on the top of threads -> framework over threads which automatically shifts threads
 *
 * Coroutines Scope -> defines lifetime
 * Coroutines Context -> defines to run on which thread -> Dispatchersc
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

        binding.btn.setOnClickListener {

            //imp
//            CoroutineScope(Dispatchers.IO).launch {
//                System.out.println("CoroutineScope, IO Dispatcher " + Thread.currentThread().name)
//            }
//
//            GlobalScope.launch {
//                System.out.println("GlobalScope, No Dispatcher " + Thread.currentThread().name)
//            }
//            MainScope().launch {
//                System.out.println("MainScope, No Dispatcher " + Thread.currentThread().name)
//            }


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

//            CoroutineScope(Dispatchers.IO).launch {
//                task1()
//            }
//            CoroutineScope(Dispatchers.IO).launch {
//                task2()
//            }

            /**
             * 2.
             *  output of below 2 lines
             *  COROUTINES_LEARN Starting Task 1 - start
             *  COROUTINES_LEARN Ending Task 1 - 10 seconds
             *  COROUTINES_LEARN Starting Task 2 - immediate
             *  COROUTINES_LEARN Ending Task 2 - 10 seconds
             *
             *  tasks inside one coroutine runs in sequence, regardless of whether they are suspend or not and  suspension points are available or not
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

            CoroutineScope(Dispatchers.IO).launch{
                println("I want to print")
                val data = prepareData()
                println("data: " + data )
                println("I want to print2")
            }

            /**
             * 3.
             * Coroutines Builder ->> launch, async -> returns job
             */
//            CoroutineScope(Dispatchers.IO).launch {
//                printFollowers()
//            }
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
        val data = listOf<Song>(Song(1, "telugu", "one", 12, null ))
        println(data)
        return data
    }


    private suspend fun task1(){
        println(TAG+"Starting Task 1")
        delay(1000) // any long running task like api call that is called withContext-actual suspension point
        println(TAG+"Ending Task 1")
    }

    private suspend fun task2(){
        println(TAG+"Starting Task 2")
        delay(1000) // any long running task like api call that is called withContext-actual suspension point
        println(TAG+"Ending Task 2")
    }

    private suspend fun printFollowers(){
        var followers = 0;
        /**
         * 4.
         * launch builder just builds the coroutines and changes into diff coroutine if there is an actual suspend point
         * but this does not ensure that if any result is returned from this coroutine is available before the execution of next line that is out of coroutine scope
         * in below coroutine, followers variable in println will be 0 as getFollowers() takes time and its built with launch builder
         * launch -> fire and forget
         */
//        CoroutineScope(Dispatchers.IO).launch {
//            followers = getFollowers()
//        }
//        println(TAG+ "4. Number of followers = "+ followers)

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
         */

//        val job2 = CoroutineScope(Dispatchers.IO).async {
//            getFollowers()
//        }
//        println(TAG+ "7. Number of followers = "+ job2.await()) // waiting till job2 response is available

        /**
         * 8.
         * more example of above using 2 coroutines
         * fb, insta parallel, but waits until both results are available
         */
//        val fb = CoroutineScope(Dispatchers.IO).async {
//            getFBFollowers()
//        }
//        val insta = CoroutineScope(Dispatchers.IO).async {
//            getInstaFollowers()
//        }
//        println(TAG+ "8. Number of FB followers = "+ fb.await() + " Number of Insta followers = " + insta.await())

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
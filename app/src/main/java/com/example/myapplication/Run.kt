import com.example.myapplication.retroMvvmRecycler.network.RetrofitService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.cancellation.CancellationException

 suspend fun main() {
//    startNormalJob()
//    startSupervisorJob()
//    val flow = getFlow()
//    flow.collect {
//        println(it)
//    }

//    val myString = "Datta"
//    val ans = myString.modifiedExtensionString()
//    println(ans)
//    getUsers().collect {
//        println(it?.body()?.get(0))
//    }

//    latestTest()

     val job2 = CoroutineScope(Dispatchers.IO).async {
         getFollowers()
     }
     println("i am a normal line before") // waiting till job2 response is available
     println("Number of followers = " + job2.await()) // waiting till job2 response is available
     println("i am a normal line after") // waiting till job2 response is available
 }

private suspend fun getFollowers(): Int {
    delay(5000)
    return 99
}

suspend fun latestTest() {
    CoroutineScope(Dispatchers.IO).launch {
        println("1st, CoroutineScope, IO Dispatcher ${Thread.currentThread().name}")
        shiftAnotherCoroutine()
    }
    delay(1)
}

fun shiftAnotherCoroutine() {
    CoroutineScope(Dispatchers.Default).launch {
        println("2nd, CoroutineScope, Default Dispatcher ${Thread.currentThread().name}")
    }
}


fun String.modifiedExtensionString(): String {
    return "Karthik $this"
}


suspend fun getFlow() = flow<Int> {
    delay(10)
    emit(1)
}

suspend fun getUsers() = flow {
    val retrofit = RetrofitService.getInstance()
    retrofit.getUsers().enqueue(object : Callback<List<String>> {
        override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
            CoroutineScope(Dispatchers.Main).launch {
                emit(response)
            }
        }

        override fun onFailure(call: Call<List<String>>, t: Throwable) {
            CoroutineScope(Dispatchers.Main).launch {
                emit(null)
            }
        }
    });
}


fun startNormalJob() {
    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception caught: ${throwable.message}")
        }
        val parentJob = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val job1 = launch {
                delay(1000)
                println("hello")
            }
            val job2 = launch {
                delay(2000)
                println("world")
                throw RuntimeException("Job 2 failed")
            }
            val job3 = launch {
                delay(3000)
                println("again")
            }
        }
        parentJob.join()
    }
}

fun startSupervisorJob() {

    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception caught: ${throwable.message}")
        }

        val supervisorJob = SupervisorJob()
        val parentJob = CoroutineScope(supervisorJob + Dispatchers.IO + exceptionHandler).launch {
            val job1 = launch {
                delay(1000)
                println("hello")
            }
            val job2 = launch {
                delay(2000)
                println("world")
                throw RuntimeException("Job 2 failed")
            }
            val job3 = launch {
//                delay(3000)
//                println("again")

                try {
                    delay(3000)
                    println("again")
                } catch (e: CancellationException) {
                    println("Job 3 was cancelled")
                }
            }
        }
        parentJob.join()
    }
}

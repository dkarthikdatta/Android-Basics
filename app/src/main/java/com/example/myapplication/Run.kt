import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main() {
//    startNormalJob()
    startSupervisorJob()
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


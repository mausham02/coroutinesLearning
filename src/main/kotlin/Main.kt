import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {
    println("Main Threads starts: ${Thread.currentThread().name}")
//    val jobDeferred: Deferred<String> = async {
//        println("Random work starts: ${Thread.currentThread().name}")
//        mySuspendFunc(1000)
//        println("Random work finished: ${Thread.currentThread().name}")
//        "Mausham Shrestha"
//    }
////    jobDeferred.join();
//    val num:String = jobDeferred.await()

    val job: Job = launch(Dispatchers.Default) {
        try {
            for (i in 0..100) {
                print("$i.")
                delay(5)

        }} catch (e: CancellationException) {
            print("\n${e.message}")
        } finally {
            withContext(NonCancellable) {// This lets the delay to run even after the coroutine being cancelled because it creates the new function
                delay(1000)
                print("\nClose resources in finally")
            }

        }
    }
    delay(200)
    job.cancel(CancellationException("My own message"));
    job.join()
    println("Main Threads Stops: ${Thread.currentThread().name}")
//    println(num)
}

suspend fun mySuspendFunc(time: Long) {
    delay(time)
}


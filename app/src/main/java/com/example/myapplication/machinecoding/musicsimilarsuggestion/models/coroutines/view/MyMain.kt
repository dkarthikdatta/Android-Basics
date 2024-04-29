package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.view

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.data.DataRepository
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.presenter.ISuggestionPresenter
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.presenter.SuggestionPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyMain : IView {
    private val presenter: ISuggestionPresenter = SuggestionPresenter(this)

    fun start() {
        presenter.onStart()
    }

    override fun playCurrent(songName: String) {
        println("Playing Song: $songName")
    }

}

suspend fun main() {
    val myMain: MyMain = MyMain();
    myMain.start()

//    println("in onStart of presenter")
//    println("before launch coroutine")
//
//    val job1 = CoroutineScope(Dispatchers.IO + SupervisorJob()).async {
//        val ans = async {
//            println("in coroutineScope of SuggestionPresenter")
//            delay(1000)
//        }
//    }
//    job1.await()
//
//    println("after launch coroutine")
}
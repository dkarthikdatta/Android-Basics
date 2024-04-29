package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.presenter

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.data.DataRepository
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.view.IView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuggestionPresenter(val view: IView) : ISuggestionPresenter {

    private lateinit var dataRepository: DataRepository
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    override fun onStart() {
        println("in onStart of presenter")
        dataRepository = DataRepository()

        println("before launch coroutine")
        coroutineScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    dataRepository.prepareData()
                }
                println("data = " + data)
            } catch (e: Exception) {
                println("ex + " + e.message)
            }
        }
        println("after launch coroutine")
    }

    override fun onSongPlay(id: Int) {
//        view.playCurrent()
    }
}
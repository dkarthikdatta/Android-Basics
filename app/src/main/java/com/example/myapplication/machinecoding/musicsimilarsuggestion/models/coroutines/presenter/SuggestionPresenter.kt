package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.presenter

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.data.DataRepository
import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.view.IView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class SuggestionPresenter(val view: IView) : ISuggestionPresenter {

    private lateinit var dataRepository: DataRepository
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    override fun onStart() {
        println("in onStart of presenter")
        dataRepository = DataRepository()

        println("before launch coroutine")
        coroutineScope.launch {
            println("I want to print")
            val data = prepareData()
            println("I want to print2")
            if(data.isNotEmpty()){
                println("after launch coroutine" + data)
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
        val json =
            File("/Users/karthikdatta/Desktop/Repos/Learn/app/src/main/java/com/example/myapplication/machinecoding/musicsimilarsuggestion/models/data.json").readText()
        val gson = Gson()
        val songListType = object : TypeToken<List<Song>>() {}.type
        val data = gson.fromJson<List<Song>>(json, songListType)
        println(data)
        return data
    }

    override fun onSongPlay(id: Int) {
//        view.playCurrent()
    }
}
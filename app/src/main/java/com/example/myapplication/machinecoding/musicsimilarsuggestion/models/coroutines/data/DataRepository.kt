package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.data

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataRepository {
    lateinit var data: List<Song>
    val dataSource: DataSource = DataSource();
    suspend fun prepareData() {
        println("in prepareData of DataRepository")
        data = dataSource.getData()
//        println(data)
//        when (val d = data) {
//            is List -> {
//                println("data = " + d)
//            }
//        }
    }
}
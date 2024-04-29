package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.data

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File

class DataSource {

    suspend fun getData(): List<Song> {
        return withContext(Dispatchers.IO) {
            println("Helloooo")
//        delay(10)
            val json =
                File("/Users/karthikdatta/Desktop/Repos/Learn/app/src/main/java/com/example/myapplication/machinecoding/musicsimilarsuggestion/models/data.json").readText()
            val gson = Gson()
            val songListType = object : TypeToken<List<Song>>() {}.type
            val data = gson.fromJson<List<Song>>(json, songListType)
            println(data)
            data
        }
    }
}
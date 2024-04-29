package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.normal

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class DataSource {

    public fun getData(): List<Song> {
        val json =
            File("/Users/karthikdatta/Desktop/Repos/Learn/app/src/main/java/com/example/myapplication/machinecoding/musicsimilarsuggestion/models/data.json").readText()
        val gson = Gson()
        val songListType = object : TypeToken<List<Song>>() {}.type
        return gson.fromJson(json, songListType)
    }

}
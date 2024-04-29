package com.example.myapplication.machinecoding.musicsimilarsuggestion.models

data class Song(
    val id: Int,
    val name: String,
    val singer: String,
    val popularity: Int,
    val similarSongs: List<Int>
)
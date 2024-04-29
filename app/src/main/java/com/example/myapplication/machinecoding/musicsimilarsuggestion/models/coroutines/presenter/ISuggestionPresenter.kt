package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.coroutines.presenter

interface ISuggestionPresenter {
    fun onStart();
    fun onSongPlay(id: Int)

}
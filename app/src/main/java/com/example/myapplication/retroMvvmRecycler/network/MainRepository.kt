package com.example.myapplication.retroMvvmRecycler.network

class MainRepository(private val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()
}
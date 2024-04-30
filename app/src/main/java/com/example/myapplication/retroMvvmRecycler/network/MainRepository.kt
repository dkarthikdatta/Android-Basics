package com.example.myapplication.retroMvvmRecycler.network

class MainRepository(val retrofitService: RetrofitService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()
}
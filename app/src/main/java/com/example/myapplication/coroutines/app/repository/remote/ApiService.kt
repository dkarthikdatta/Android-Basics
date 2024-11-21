package com.example.myapplication.coroutines.app.repository.remote

import com.example.myapplication.coroutines.app.model.Category
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {


    @GET("categories")
    fun getCategories(): List<Category>

    companion object {
        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

        private var apiService: ApiService? = null
        private val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()

        fun getInstance(): ApiService {
            return apiService ?: synchronized(this) {
                apiService ?: retrofit.run {
                    apiService = this.create(ApiService::class.java)
                    apiService!!
                }
            }
        }
    }
}
package com.example.myapplication.flow.mvvm.api

import com.example.myapplication.flow.mvvm.model.Category
import com.example.myapplication.flow.mvvm.model.CategoryResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategoriesAsResult(): Response<CategoryResponse>

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("more-users")
    suspend fun getMoreUsers(): List<Category>

    @GET("error")
    suspend fun getUsersWithError(): List<Category>


    object RetrofitBuilder {

        private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    }
}
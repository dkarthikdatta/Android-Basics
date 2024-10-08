package com.example.myapplication.flow.mvvm.api

import com.example.myapplication.flow.mvvm.model.Category
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    suspend fun getCategoriesFromFlow(): Flow<List<Category>>
    fun getMoreUsers(): Flow<List<Category>>
    fun getUsersWithError(): Flow<List<Category>>
    suspend fun getCategoriesFromCoroutine(): MyResult
}
package com.example.myapplication.flow.mvvm.db

import com.example.myapplication.flow.mvvm.model.Category
import kotlinx.coroutines.flow.Flow

interface DBHelper {
    suspend fun getCategoriesFromDB(): Flow<List<Category>>
    suspend fun insert(categories: List<Category>): Flow<Unit>
}
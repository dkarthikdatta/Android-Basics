package com.example.myapplication.flow.mvvm.repository

import com.example.myapplication.flow.mvvm.api.ApiHelper
import com.example.myapplication.flow.mvvm.api.MyResult
import com.example.myapplication.flow.mvvm.db.DBHelper
import com.example.myapplication.flow.mvvm.model.Category
import kotlinx.coroutines.flow.Flow

class Repository(private val apiHelper: ApiHelper, private val dbHelper: DBHelper) {

    suspend fun getCategoriesFromFlow(): Flow<List<Category>> {
        return apiHelper.getCategoriesFromFlow()
    }

    suspend fun getUsersFromCoroutine(): MyResult {
        return apiHelper.getCategoriesFromCoroutine()
    }

    suspend fun getCategoriesFromDB(): Flow<List<Category>> {
        return dbHelper.getCategoriesFromDB()
    }

    suspend fun sendCategoriesToDB(categories: List<Category>): Flow<Unit> {
        return dbHelper.insert(categories)
    }
}
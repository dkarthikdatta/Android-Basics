package com.example.myapplication.coroutines.app.repository.remote

import com.example.myapplication.coroutines.app.model.Category
import com.example.myapplication.coroutines.app.repository.DataHelper

class RemoteDataSource(private val apiService: ApiService) : DataHelper {
    override fun getCategoryList(): List<Category> {
        return apiService.getCategories()
    }
}
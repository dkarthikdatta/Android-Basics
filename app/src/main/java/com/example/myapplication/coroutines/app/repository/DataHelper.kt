package com.example.myapplication.coroutines.app.repository

import com.example.myapplication.coroutines.app.model.Category


interface DataHelper {
    fun getCategoryList(): List<Category>
}
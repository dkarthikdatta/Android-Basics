package com.example.myapplication.coroutines.app.repository.local

import android.content.Context
import com.example.myapplication.coroutines.app.model.Category
import com.example.myapplication.coroutines.app.repository.DataHelper
import com.example.myapplication.roomdb.ContactDataBase

class LocalDataSource(private val dataBase: MyDatabase) : DataHelper {
    override fun getCategoryList(): List<Category> {
        return dataBase.categoriesDao().getAllCategories()
    }
}
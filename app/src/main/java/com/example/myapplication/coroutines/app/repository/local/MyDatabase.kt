package com.example.myapplication.coroutines.app.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.coroutines.app.model.Category

@Database(entities = [Category::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao
}
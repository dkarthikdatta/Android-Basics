package com.example.myapplication.flow.mvvm.db.dbRelated

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.flow.mvvm.model.Category

@Database(entities = [Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}

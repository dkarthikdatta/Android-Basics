package com.example.myapplication.flow.mvvm.db.dbRelated

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.flow.mvvm.model.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): List<Category>

    @Insert
    fun insertAll(categories: List<Category>)

    @Delete
    fun delete(category: Category)
}
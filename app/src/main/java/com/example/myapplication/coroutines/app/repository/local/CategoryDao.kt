package com.example.myapplication.coroutines.app.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.coroutines.app.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAllCategories(): List<Category>

    @Insert
    fun insertCategory(category: Category)


}
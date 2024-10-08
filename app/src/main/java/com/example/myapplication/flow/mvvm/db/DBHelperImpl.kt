package com.example.myapplication.flow.mvvm.db

import com.example.myapplication.flow.mvvm.db.dbRelated.AppDatabase
import com.example.myapplication.flow.mvvm.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow


class DBHelperImpl(private val appDatabase: AppDatabase) : DBHelper {
    override suspend fun getCategoriesFromDB(): Flow<List<Category>> {
        return flow {
            emit(appDatabase.categoryDao().getAll())
        }
    }

    override suspend fun insert(categories: List<Category>): Flow<Unit> {
        appDatabase.categoryDao().insertAll(categories)
        return flow {
            emit(Unit)
        }
    }


}
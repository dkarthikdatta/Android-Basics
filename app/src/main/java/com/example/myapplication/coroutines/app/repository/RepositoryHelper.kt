package com.example.myapplication.coroutines.app.repository

import com.example.myapplication.coroutines.app.model.Category
import com.example.myapplication.coroutines.app.repository.local.LocalDataSource
import com.example.myapplication.coroutines.app.repository.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryHelper(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getCategoryList(): List<Category>? {
        var localResponse: List<Category>? = null
        withContext(Dispatchers.IO) {
            localResponse = localDataSource.getCategoryList()
        }
        if (localResponse == null) {
            localResponse = remoteDataSource.getCategoryList()
        }
        return localResponse
    }
}
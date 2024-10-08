package com.example.myapplication.flow.mvvm.api

import com.example.myapplication.flow.mvvm.model.Category
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getCategoriesFromFlow(): Flow<List<Category>> {
        return flowOf(apiService.getCategories().categoryResponse)
    }

    override suspend fun getCategoriesFromCoroutine(): MyResult {
        delay(5000)
        val retrofitResponse = apiService.getCategoriesAsResult()
        if(retrofitResponse.isSuccessful){
            retrofitResponse.body()?.let{
                return MyResult.ApiResponse(it)
            } ?: run { return MyResult.Error("Empty response",204) }
        }
        return MyResult.Error(retrofitResponse.errorBody()?.toString(), retrofitResponse.code())
    }

    override fun getMoreUsers() = flow {
        emit(apiService.getMoreUsers())
    }

    override fun getUsersWithError() = flow {
        emit(apiService.getUsersWithError())
    }

}
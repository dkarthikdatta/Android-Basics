package com.example.myapplication.flow.mvvm.api

import com.example.myapplication.flow.mvvm.model.CategoryResponse

sealed class MyResult {
    class ApiResponse(val data: CategoryResponse) : MyResult()
    class Error(val errorBody: String?, val errorCode: Int?) : MyResult()
    class Loader() : MyResult()
}
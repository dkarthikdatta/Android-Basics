package com.example.myapplication.coroutines.app.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.coroutines.app.model.Category
import com.example.myapplication.coroutines.app.repository.DataHelper
import com.example.myapplication.coroutines.app.repository.RepositoryHelper
import kotlinx.coroutines.launch

class MyViewModel(private val repositoryHelper: RepositoryHelper) : ViewModel() {

    private val mutableLiveDataList = MutableLiveData<List<Category>>()

    val liveDataList: LiveData<List<Category>>
        get() = mutableLiveDataList

    init {
        makeApiCall()
    }

    private fun makeApiCall() {
        viewModelScope.launch {
            val response = repositoryHelper.getCategoryList()
            response?.let {
                mutableLiveDataList.postValue(it)
            }
        }
    }

}
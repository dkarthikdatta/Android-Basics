package com.example.myapplication.flow.mvvm.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.flow.mvvm.api.MyResult
import com.example.myapplication.flow.mvvm.model.Category
import com.example.myapplication.flow.mvvm.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GenericViewModel(private val repository: Repository, private val isFlow: Boolean) :
    ViewModel() {

    // flow

    // same as live data and mutable live data, use StateFlow and MutableStateFlow for exposing data to Activity
    private val _categoryStateFlow = MutableStateFlow<List<Category>>(emptyList())

    // since need to collect data in activity, and collect is suspend function,
    // need a coroutine to be launched on main thread. since main  coroutine, if activity is recreated, again listen - own lifecycle handling
    val categoryStateFlow: StateFlow<List<Category>>
        get() = _categoryStateFlow

    // can handle like this also using live data
    val categoryLiveDataFromFlow: LiveData<List<Category>>
        get() = _categoryStateFlow.asLiveData()


    //coroutine

    private val _categoryMutableLiveData = MutableLiveData<List<Category>>()

    val categoryLiveData: LiveData<List<Category>>
        get() = _categoryMutableLiveData

    private val _errorMsg = MutableLiveData<String>()

    val errorMsgLiveData: LiveData<String>
        get() = _errorMsg

    private val _loader = MutableLiveData<Boolean>()

    val loaderLiveData: LiveData<Boolean>
        get() = _loader

    init {
        if (isFlow) {
            fetchUsersFromFlow()
        } else {
            fetchUserFromCoroutine()
        }
    }

    private fun fetchUsersFromFlow() {


        _loader.postValue(true)
        viewModelScope.launch {

            repository.getCategoriesFromDB().collect {
                if (it.isNotEmpty()) {
                    println("TEST_KD, flow, DB data is not empty")
                    _categoryStateFlow.value = it
                } else {
                    println("TEST_KD, flow, DB data is empty")
                    repository.getCategoriesFromFlow()
                        .collect { categories ->// since this is suspend function, we need to launch in coroutine
                            // here we are getting only flow data. we need to pass to state flow
                            _categoryStateFlow.value = categories
                            sendDataToDB(categories)
                        }
                }
            }


        }
    }

    private fun fetchUserFromCoroutine() {
        _loader.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {

            repository.getCategoriesFromDB().collect {
                if (it.isNotEmpty()) {
                    println("TEST_KD, coroutine, DB data is not empty")
                    _categoryMutableLiveData.postValue(it)
                    _loader.postValue(false)
                } else {
                    println("TEST_KD, coroutine, DB data is empty")
                    // no need to switch context to IO dispatcher.
                    // The low-level, where actual blocking code - the api call at retrofit end,
                    // the context switching should and will happen
                    when (val result: MyResult = repository.getUsersFromCoroutine()) {
                        is MyResult.ApiResponse -> {
                            _categoryMutableLiveData.postValue(result.data.categoryResponse)
                            _loader.postValue(false)

                            sendDataToDB(result.data.categoryResponse)
                        }

                        is MyResult.Error -> {
                            _errorMsg.postValue(result.errorBody?.toString())
                            _loader.postValue(false)
                        }

                        is MyResult.Loader -> _loader.postValue(true)
                        else -> {}
                    }
                }

            }


        }
    }

    private fun sendDataToDB(categoryList: List<Category>) {
        viewModelScope.launch(Dispatchers.IO) {
            println("TEST_KD, setting data to db, $categoryList")
            repository.sendCategoriesToDB(categoryList)
        }
    }
}
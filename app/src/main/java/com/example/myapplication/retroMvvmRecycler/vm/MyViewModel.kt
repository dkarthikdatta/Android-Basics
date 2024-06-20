package com.example.myapplication.retroMvvmRecycler.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.retroMvvmRecycler.network.MainRepository
import com.example.myapplication.retroMvvmRecycler.network.MovieDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel(val repository: MainRepository) : ViewModel() {

    private val movieList = MutableLiveData<List<MovieDataItem>>()

    val moviesLiveData: LiveData<List<MovieDataItem>>
        get() = movieList

    fun getMovies(){
        viewModelScope.launch {
            val response = repository.getAllMovies()
            if(response.isSuccessful){
                withContext(Dispatchers.Main){
                    movieList.postValue(response.body())
                }
            } else {
                withContext(Dispatchers.Main){

                }
            }
        }
    }

}
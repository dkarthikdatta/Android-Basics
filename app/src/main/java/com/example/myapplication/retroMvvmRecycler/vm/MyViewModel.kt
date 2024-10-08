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

class MyViewModel(private val repository: MainRepository) : ViewModel() {

    private val movieList = MutableLiveData<List<MovieDataItem>>()

    private val myMutableLiveData = MutableLiveData<Int>()

    val myLiveData: LiveData<Int>
        get() = myMutableLiveData

    val moviesLiveData: LiveData<List<MovieDataItem>>
        get() = movieList

    fun getMovies() {
        /**
         * even though launch is fire and forget, the entire code in this getMovies() (unlike main)
         * runs regardless of api time taken
         *
         *  this is because, viewModelScope is active for whole activity unlike
         *  main where the lifecycle ends immediately
         *
         *
         * suspend functions/normal functions/lines of code inside coroutines execute in sequence
         * coroutines inside coroutines execute concurrently
         */
        viewModelScope.launch {
            val response = repository.getAllMovies()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    movieList.postValue(response.body())
                } else{
                    println("error")
                }
            }
        }

        /**
         * viewModelScope.launch {
         *             val response1 = repository.getAllMovies() // suspend function
         *             val response2 = repository2.getAllMovies() // suspend function
         *             viewModelScope.launch {
         *                 //1st coroutine
         *             }
         *             viewModelScope.launch {
         *                 //2nd coroutine
         *             }
         *             val response3 = repository3.getAllMovies() // suspend function
         *             viewModelScope.launch {
         *                 //3rd coroutine
         *             }
         *    }
         *    Order of execution
         *    1st coroutine, 2nd coroutine, 3rd coroutine run concurrently as these are coroutines
         *    below these run in order of sequence regardless how much time the function takes time to get results
         *    response1
         *    response2
         *    response3
         */
    }

}
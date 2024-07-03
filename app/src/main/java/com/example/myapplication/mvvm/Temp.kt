package com.example.myapplication.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Temp : AppCompatActivity() {
    private lateinit var viewModel: TempViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, TempViewModelFactory(0)).get(TempViewModel::class.java)
        viewModel.myLiveData.observe(this, Observer {
            println(it)
        })
    }
}


class TempViewModel(private val startInt: Int) : ViewModel() {
    private val myMutableLiveData: MutableLiveData<Int> = MutableLiveData(0)

    val myLiveData: LiveData<Int>
        get() = myMutableLiveData

    init {
        // make api call with startInt

        myMutableLiveData.postValue(300)
    }
}

class TempViewModelFactory(private val startInt: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TempViewModel(startInt) as T
    }

}
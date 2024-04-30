package com.example.myapplication.retroMvvmRecycler.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.retroMvvmRecycler.network.MainRepository

class MyViewModelFactory(val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(repository) as T
    }
}
package com.example.myapplication.flow.mvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.flow.mvvm.repository.Repository

class GenericViewModelFactory(private val repository: Repository, private val isFlow: Boolean) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenericViewModel(repository, isFlow) as T
    }
}
package com.example.myapplication.coroutines.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.coroutines.app.vm.MyViewModel
import com.example.myapplication.databinding.ActivityMain4Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.example.myapplication.threading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

class ThreadingActivity : AppCompatActivity() {

    private val singleThreadDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threading)
    }
}
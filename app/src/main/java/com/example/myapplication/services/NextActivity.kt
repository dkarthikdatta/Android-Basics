package com.example.myapplication.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            Log.d("MY_BG_SERVICE", "clicked start button in NextActivity")
            startService(Intent(this, MyBackgroundService::class.java))
        }

        binding.stop.setOnClickListener {
            Log.d("MY_BG_SERVICE", "clicked stop button in NextActivity")
            stopService(Intent(this, MyBackgroundService::class.java))
        }
    }
}
package com.example.myapplication.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMyForServiceBinding

class MyActivityForService : AppCompatActivity() {

    lateinit var biding: ActivityMyForServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMyForServiceBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.start.setOnClickListener {
            Log.d("MY_BG_SERVICE", "clicked start button in MyActivityForService")
            startService(Intent(this, MyBackgroundService::class.java))
        }

        biding.stop.setOnClickListener {
            Log.d("MY_BG_SERVICE", "clicked stop button in MyActivityForService")
            stopService(Intent(this, MyBackgroundService::class.java))
        }

        biding.nextPage.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }

    }
}
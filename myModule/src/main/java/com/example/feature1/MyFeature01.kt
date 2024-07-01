package com.example.feature1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mysdk.R

class MyFeature01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_modular)


        val intent = intent
        if (intent.action == Intent.ACTION_VIEW) {
            val data: Uri? = intent.data
            if (data != null) {
                // Handle the deep link data here
                // For example, extract information from the URI
            }
        }

    }
}
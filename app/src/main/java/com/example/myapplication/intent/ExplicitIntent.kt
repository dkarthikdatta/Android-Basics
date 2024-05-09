package com.example.myapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class ExplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

        Intent(Intent.ACTION_MAIN).also {
            it.`package` = "com.google.android.youtube" // sending to other app
            startActivity(it)
        }
    }
}
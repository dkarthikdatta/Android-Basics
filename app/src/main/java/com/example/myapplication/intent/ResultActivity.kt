package com.example.myapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dataFromFirstActivity.text = intent.getStringExtra("name")
        binding.gotoPrev.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("superName", binding.resultText.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}
package com.example.myapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    val TAG = "INTENT_ACTIVITY "

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "in onCreate of Result Activity")
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


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "in onStart of Result Activity")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "in onRestoreInstanceState of Result Activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "in onResume of Result Activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "in onPause of Result Activity")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "in onSaveInstanceState of Result Activity")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "in onStop of Result Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "in onDestroy of Result Activity")
    }

}
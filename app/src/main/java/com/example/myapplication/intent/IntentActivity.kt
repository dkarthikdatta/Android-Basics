package com.example.myapplication.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    val TAG = "INTENT_ACTIVITY "
    private lateinit var binding: ActivityIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "in onCreate of Intent Activity")
        binding = ActivityIntentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            explicitIntent.setOnClickListener {
                val intent = Intent(this@IntentActivity, NextActivity::class.java)
                startActivity(intent)
            }

            explicitIntentForResult.setOnClickListener {
                val intent = Intent(this@IntentActivity, ResultActivity::class.java)
                intent.putExtra("name", "karthik")
                getResult.launch(intent)
//                startActivityForResult(intent, 1234)
            }

            explicitIntentToOtherApp.setOnClickListener {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.`package` = "com.google.android.youtube"
                startActivity(intent)
            }

            implicitIntent.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, binding.textForSharing.text.toString())
//                startActivity(intent)
                startActivity(Intent.createChooser(intent, "Share via custom descr"))
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "in onStart of Intent Activity")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "in onRestoreInstanceState of Intent Activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "in onResume of Intent Activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "in onPause of Intent Activity")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "in onSaveInstanceState of Intent Activity")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "in onStop of Intent Activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "in onDestroy of Intent Activity")
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1234) { // to check which started intent is resulted back
//            if (resultCode == RESULT_OK) { // next activity sets result ok on returning
//                Toast.makeText(this, data?.getStringExtra("superName"), Toast.LENGTH_LONG).show()
//            }
//        }
//    }

    // Receiver
    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data = it.data
                Toast.makeText(this, data?.getStringExtra("superName"), Toast.LENGTH_LONG).show()
            }
        }

}
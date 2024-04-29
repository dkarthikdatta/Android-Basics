package com.example.myapplication.handlerlooper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHandlerBinding


/**
 *
 */
class HandlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHandlerBinding
    private val TAG = "HANDLER"
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(applicationContext.mainLooper)

        binding.start.setOnClickListener {
            Thread {
                handler.post {
                    // here, we need to post the update in main thread.
                    // if we dont user handler of Main thread, we are then trying to update main thread from another thread
                    // hence we need use main handler to post updates from another thread
                    binding.textView.text = Thread.currentThread().name
                    Log.d(TAG, Thread.currentThread().name)
                }
                Log.d(TAG, Thread.currentThread().name)
            }.start()
        }

        binding.stop.setOnClickListener {
            while (true){
                Thread {
                    Thread.sleep(2000)
                    Log.d(TAG, Thread.currentThread().name)
                }.start()
//                Thread {
//                    Thread.sleep(2000)
//                    Log.d(TAG, Thread.currentThread().name)
//                }.start()
            }
        }
    }
}
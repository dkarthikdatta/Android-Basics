package com.example.myapplication.sdk

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySdkmainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class SDKMainActivity : AppCompatActivity() {
    lateinit var binding: ActivitySdkmainBinding

    val executorService: ExecutorService = Executors.newSingleThreadExecutor();
    val handler = Handler(Looper.getMainLooper())
    val mysdk = MYSDK.getINSTANCE(this)
    var count: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySdkmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDb(this)

        // Inserting Students

        // Inserting Students
        binding.button.setOnClickListener {
            for (i in 0..50){
                mysdk.sendEvent((count + 97).toChar().toString(), count)
                count++
            }
        }

        binding.clearDB.setOnClickListener {
//            executorService.execute {
//                db.deleteAllStudents()
//            }
        }

    }
}
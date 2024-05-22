package com.example.myapplication.services

import android.app.Service
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.IBinder
import android.util.Log
import java.util.Timer
import java.util.TimerTask


class MyBackgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("MY_BG_SERVICE", "in OnCreate of bg service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MY_BG_SERVICE", "in onStartCommand of bg service")
//        val timer = Timer()
//
//        val timerTask = object : TimerTask() {
//            override fun run() {
//                startActivity(Intent(this@MyBackgroundService, NextActivity::class.java))
//            }
//        }
//        timer.schedule(timerTask, 2000.toLong())

        return START_STICKY_COMPATIBILITY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MY_BG_SERVICE", "in onDestroy of bg service")
    }
}
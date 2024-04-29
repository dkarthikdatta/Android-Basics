package com.example.myapplication.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class UserApplication: Application() {
//    @Inject
//    lateinit var userRepo: UserRepo
//
//    override fun onCreate() {
//        super.onCreate()
//        userRepo.saveUser("abc@gmail.com", "paswww")
//    }
}
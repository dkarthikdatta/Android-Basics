package com.example.myapplication.hilt

import android.util.Log
import javax.inject.Inject

class UserRepo @Inject constructor(){
    fun saveUser(email: String, pass: String){
        Log.d("HILT", "User saved in repo")
    }

}
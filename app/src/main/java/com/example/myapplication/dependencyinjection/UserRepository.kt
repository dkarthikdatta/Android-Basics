//package com.example.myapplication.dependencyinjection
//
//import android.util.Log
//import javax.inject.Inject
//
//interface UserRepository {
//    fun saveUser(email: String, pass: String)
//}
//
//class SQLRepo @Inject constructor() : UserRepository {
//    override fun saveUser(email: String, pass: String) {
//        Log.d("DAGGER", "User saved in SQL repository")
//    }
//
//}
//
//class FirebaseRepo: UserRepository{
//    override fun saveUser(email: String, pass: String) {
//        Log.d("DAGGER", "User saved in Fire repository")
//    }
//
//}
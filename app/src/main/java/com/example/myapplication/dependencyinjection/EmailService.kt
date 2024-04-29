//package com.example.myapplication.dependencyinjection
//
//import android.util.Log
//import javax.inject.Inject
//
//interface NotificationService {
//    fun send(to: String, from: String, body: String)
//}
//
//class EmailService @Inject constructor() : NotificationService {
//
//    override fun send(to: String, from: String, body: String) {
//        Log.d("DAGGER", "Email sent")
//    }
//}
//
//class MessageService: NotificationService{
//    override fun send(to: String, from: String, body: String) {
//        Log.d("DAGGER", "Message sent")
//    }
//
//}
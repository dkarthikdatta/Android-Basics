//package com.example.myapplication.dependencyinjection
//
//import javax.inject.Inject
//
///**
// * @Inject -> how to create object. by constructor
// * constructor injection
// */
//class UserRegistrationService @Inject constructor(
//    val userRepository: UserRepository,
//    val notificationService: NotificationService) {
//
//    fun register(email: String, password: String) {
//        userRepository.saveUser(email, password)
//        notificationService.send("to", "from", "User Registered")
//    }
//}
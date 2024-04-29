package com.example.myapplication.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

//    @Inject
//    lateinit var userRegistrationService: UserRegistrationService //field injection
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


//        val userRepository = UserRepository()
//        val emailService = EmailService()
//
//        val userRegistrationService = UserRegistrationService(userRepository, emailService)

        /**
         * constructor injection
         */
//        val component = DaggerUserRegistrationComponent.builder().build()
//
//        val userRegistrationService = component.getUserRegisterService()
//
//        val emailService = component.getEmailService()

//        val component = DaggerUserRegistrationComponent.builder().build()
//        component.inject(this)
//
//        userRegistrationService.register("emailID", "1111")
    }
}
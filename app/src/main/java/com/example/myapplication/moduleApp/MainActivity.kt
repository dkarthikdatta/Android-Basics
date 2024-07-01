package com.example.myapplication.moduleApp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.core.DeeplinkHandler
import com.example.core.DeeplinkProcessor
import com.example.core.DefaultDeeplinkHandler
import com.example.feature1.Module1DeeplinkProcessor
import com.example.myapplication.databinding.ActivityMain3Binding
import com.example.mymodule2.Module2DeeplinkProcessor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var deeplinkHandler: DeeplinkHandler
    private lateinit var processors : HashSet<DeeplinkProcessor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        processors = hashSetOf()
        processors.add(Module1DeeplinkProcessor(this))
        processors.add(Module2DeeplinkProcessor(this))
        deeplinkHandler = DefaultDeeplinkHandler(
            processors
        )
        binding.button.setOnClickListener {
//            val intent = Intent(this, MyFeature01::class.java)
//            intent.putExtra("myString", "hello moto")
//            startActivity(intent)

//            val intent = Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(
//                    "https://www.example.com/feature01"
//                )
//            )
//            startActivity(intent)
            deeplinkHandler.process("https://www.example.com/feat01")
        }

//        binding.button2.setOnClickListener {
//            val intent = Intent(this, MyFeature01::class.java)
//            intent.putExtra("myString", "hello moto")
//            startActivity(intent)
    }
}
package com.example.mymodule2

import android.content.Context
import android.content.Intent
import com.example.core.DeeplinkProcessor

class Module2DeeplinkProcessor(private val context: Context) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("feat02")
    }

    override fun execute(deeplink: String) {
        val intent = Intent(context, MyFeature02::class.java)
        context.startActivity(intent)
    }
}
package com.example.feature1

import android.content.Context
import android.content.Intent
import com.example.core.DeeplinkProcessor

class Module1DeeplinkProcessor(private val context: Context) : DeeplinkProcessor {
    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("feat01")
    }

    override fun execute(deeplink: String) {
        val intent = Intent(context, MyFeature01::class.java)
        context.startActivity(intent)
    }
}
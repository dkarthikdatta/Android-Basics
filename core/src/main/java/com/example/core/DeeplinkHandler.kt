package com.example.core

interface DeeplinkHandler {
    fun process(deeplink: String): Boolean
}
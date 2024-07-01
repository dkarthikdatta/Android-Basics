package com.example.core

class DefaultDeeplinkHandler constructor(
    private val processors: Set<DeeplinkProcessor>
) : DeeplinkHandler {
    override fun process(deeplink: String): Boolean {
        processors.forEach {
            if (it.matches(deeplink)) {
                it.execute(deeplink)
                return true
            }
        }
        return false
    }
}
package com.example.myapplication.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.Random

class ApiCall {

    suspend fun getApiResponse(): String {
        return withContext(Dispatchers.IO){// making the function launch in Dispatchers.IO by ourselves as this is custom api call. in retrofit, no need to do this. since retrofit implements mainsafe - switches to io even if called from main
            val sb: StringBuilder = StringBuilder()
            val rand: Random = Random()
            for(i in 0..100){
                delay(10)
                sb.append((96+rand.nextInt(27)).toChar())
            }
            sb.toString()
        }
    }
}
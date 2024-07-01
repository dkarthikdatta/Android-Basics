package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun main() {

    // 1, 0, 1, 1, 0, 1
    // 1, 1, 1, 1, 0, 0
    val intArray: IntArray = intArrayOf(1, 0, 0, 1, 1, 1, 1)
    var left = 0;
    var right = intArray.size - 1;
    while (left <= right) {
        if (intArray[left] == 1) {
            left++
        } else if (intArray[right] == 1) {
            val temp = intArray[left]
            intArray[left] = 1
            intArray[right] = temp
            right--
        } else {
            right--
        }
    }

    for (int in intArray) {
        println(int)
    }

}


class ViewModel() : ViewModel() {

    private val _response: MutableLiveData<Any> = MutableLiveData<Any>()

    val getMainResponse: LiveData<Any>
        get() = _response


    fun triggerAPI() {
        viewModelScope.launch {
            val response = getAPIResponse()

            when(response){
                is Resp.succ -> {
                    response.data
                }
                is Resp.fail -> {

                }
                is Resp.onLoading -> {

                }
            }
//            if (response.success) {
//                withContext(Dispatchers.Main) {
//                    _response.value = response
//                }
//                withContext(Dispatchers.IO) {
//                    getAPIResponse2(response)
//                }
//            }
        }
    }

    private suspend fun getAPIResponse(): Resp {
        delay(10)
        return Resp.succ("")
    }

    private suspend fun getAPIResponse2(requestData: Any): Resp {
        delay(10)
        return Resp.fail(400)
    }

    sealed class Resp {
        class succ(val data: String) : Resp()
        class fail(val ec: Int) : Resp()
        class onLoading(val loading: Boolean) : Resp()
    }
}


/**
 *
 * Why are we writing code in java/kotlin rather than cpp?
 * How an apk is compiled and how it runs on mobile device
 *
 * 		java/kotlin -> javacompiler? () -> java byte stream -> compiler -> dex files (Bundle / APK)  -> Android Run Time (Ahead Of Time) / Davlik Virtual Machine (Just in Time)(old)  -> machine code
 *
 *
 * APK -> install mobile -> ART (system)  machine code
 *
 *
 *
 * How JIT, ART AND DVM are different?
 * 	JVM - Java compilation   (Java bytecode)
 * 	DVM - old - specific to Android  (dex files)
 * 	ART - new - specific to Android  (dex files)
 * 	To execute specific configuration files
 * 	ART executes dex files by compiling using AOT into Machine code
 * What is JVM ? - Java Virtual Machine - to run Java byte code
 * Why are we not shipping machine code in android and what is the advantage of this?
 * 	Size of iOS application is significantly higher that the similar/same Android application
 *
 * Why , How and Process in target sdk 34?
 * 		To
 *
 * 		minSDK, compileSDK, targetSDK
 *
 * 		To enhance the security measures wrt to each sdk level. Example - enhanced notification systems, services usage etc
 *
 *
 *
 * How will you create a framework and share between different applications?
 * 		CTA, deeplink -URI
 * 			Api - CTA - endpoint
 *
 *
 *
 *
 *
 *
 *
 *
 * 	Cart(0)
 * HairCut - 1
 *
 *
 *
 * 		{
 * 			Widget:[{
 * 			Tile:”HairCut”,
 *
 * 			“Intial_count: 0,
 * 			CTA: {
 * 				“Target_uri”:  “uc/cart”
 * 			}
 * Tile:”CART”,
 *
 * 			“Intial_count: 0,
 * 			“Uopdation_method:
 * 			CTA: {
 * 				“Target_uri”:  “uc/cart”
 * 			},
 *
 *
 *
 * }
 *
 * ]
 *
 *
 *
 * Pagination_target_item: 5
 * 		}
 *
 * Methods:
 * Types of updation
 *
 * {
 *
 * }
 *
 *
 *
 * How earlier view system different compose?
 * Pagination how will in above system?
 * Coroutines?
 * Architectures
 *
 */
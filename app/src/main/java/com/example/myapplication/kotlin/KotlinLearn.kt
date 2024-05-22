package com.example.myapplication.kotlin

import com.example.myapplication.sdk.Student
import java.util.Arrays
import java.util.Stack


const val s1 = "String 1"
val s2 = KotlinLearn().myString()

//static, array vs arraylist, mutable etc
//fun main() {
//
//    // static
//    val kotlinLearn: KotlinLearn = KotlinLearn()
//    println(KotlinLearn.someStaticVariable)
//    println(KotlinLearn.geStSomeStaticMethod())
//
//    // array vs array list
//    val array = IntArray(5) // just int array
//    val studentArray = arrayOfNulls<Student>(5)
//    val nullArray: Array<Int?> = arrayOfNulls(5)
//    val arrayWithInit = arrayOf(1,2,4,5)
//
//
//    val list = listOf<Int>(1,2,3)       // read only - no modification, no appending, no setting
////    list.set()// not valid
//    val mutableList = mutableListOf<Int>(1,2,3)
//    mutableList.add(4)
//    mutableList[1] = 10
//    val arrayList = arrayListOf<Int>(2) // no much diff bw arrayListOf and mutableListOf. in arrayListOf you are specifying the implementation
//
//}

class KotlinLearn {

    companion object {
        @JvmStatic
        val someStaticVariable = 2

        @JvmStatic
        fun geStSomeStaticMethod(): String {
            return "Some static response"
        }
    }

    fun myString(): String {
        return "My String"
    }
}
//
//
//// enums, sealed classes
//fun main() {
//
//    //enums ->
//    // You have a fixed set of options that represent distinct values.
//    //Each option doesn’t require any additional properties or behaviors.
//    val myColor: Color = Color.RED
//    println(myColor)
//    val myHexColor: ColorHex = ColorHex.RED
//    println(myHexColor)
//    myHexColor.printHex()
//
//    // sealed class ->
//    // defines a closed type hierarchy with a finite number of subclasses.
//    // Sealed classes provide a powerful mechanism for creating exhaustive class hierarchies where all possible subclasses are known.
//
//    processCall(Result.Success("response data"))
//}

fun processCall(result: Result) {
    when (result) {
        is Result.Success -> {
            println(result.data)
        }

        is Result.Error -> {
            println(result.message)
        }

        is Result.Loading -> {
            println("in loading state")
        }
    }
}

enum class Color {
    RED,
    BLUE,
    YELLOW
}

enum class ColorHex(val hex: String) {
    RED("red"), // having property, just like RED = "red"
    BLUE("blue"),
    YELLOW("yellow");

    fun printHex() {
        println("Hex code of $name is $hex")    // having function
    }
}

sealed class Result {
    class Success(val data: Any) : Result()
    class Error(val message: String) : Result()
    class Loading() : Result()
}

// higher order function
//fun main() {
//    val myString: String? = null
//    someMethod(myString)
//}

fun someMethod(myString: String?) {
    println(myString?.length)
    val myNonNullString: String? = myString ?: "default String"
    println(myNonNullString!!)
}


//sample sums
fun main() {
//    longestCommonSubsequenceDpTabulation("adebc", "dcadb")
//    longestCommonSubsequenceDp("adebc", "dcadb")
//
//    val arrivalArray = arrayOf(
//        900,
//        940, 950,
//        1100,
//        1500,
//        1800
//    )
//    val depArray = arrayOf(
//        910, 1200, 1120, 1130, 1900, 2000
//    )
//    findPlatform(arrivalArray, depArray)

    createArray()
}

fun createArray() {
    //int[] array = new int[5]; -> java
    val array = IntArray(5)
    val stringArray = arrayOfNulls<String>(3)


    //int[] A = {7, 7, 7, 7, 13, 11, 12, 7}; -> java
    val arrayInit = intArrayOf(7, 7, 7, 7, 13, 11, 12, 7)

    // Student[] students = new Student[5]; -> Java
    val students = arrayOfNulls<Student>(5)

    //int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    val dp = Array(s1.length + 1) {
        IntArray(
            s2.length + 1
        )
    }
    // Student[][] student2d = new Student[4][5];
    val student2d = Array(4) {
        arrayOfNulls<Student>(5)
    }

    val hashMap = hashMapOf<Int, Int>()
    hashMap[1] = 2

    //Stack<Integer> stack = new Stack<>();
    val stack = Stack<Int>()

    for (i in array.indices) {
        array[i] = i + 1
        println(array[i])
    }

    arrayInit.forEach {
        println(it)
    }
}


private fun longestCommonSubsequenceDpTabulation(s1: String, s2: String) {
    val dp = Array(s1.length + 1) {
        IntArray(
            s2.length + 1
        )
    }
    for (i in 0 until s1.length) {
        for (j in 0 until s2.length) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            }
        }
    }
    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }
    println(dp[s1.length][s2.length])
}

private fun longestCommonSubsequenceDp(s1: String, s2: String) {
    val dp = Array(s1.length) {
        IntArray(
            s2.length
        )
    }
    for (rows in dp) {
        Arrays.fill(rows, -1)
    }
    println(longestCommonSubsequenceDpUtil(s1, s2, s1.length - 1, s2.length - 1, dp))
}

private fun longestCommonSubsequenceDpUtil(
    s1: String,
    s2: String,
    index1: Int,
    index2: Int,
    dp: Array<IntArray>
): Int {
    if (index1 < 0 || index2 < 0) {
        return 0
    }
    if (dp[index1][index2] != -1) {
        return dp[index1][index2]
    }
    return if (s1[index1] == s2[index2]) {
        1 + longestCommonSubsequenceDpUtil(s1, s2, index1 - 1, index2 - 1, dp).also {
            dp[index1][index2] = it // if both chars same, decrease the index for both
        }
    } else Math.max(
        longestCommonSubsequenceDpUtil(s1, s2, index1 - 1, index2, dp),
        longestCommonSubsequenceDpUtil(s1, s2, index1, index2 - 1, dp)
    ).also {
        dp[index1][index2] = it
    }
    // checking if reducing index of either string produces max length
}

private fun findPlatform(arr: Array<Int>, dep: Array<Int>) {
    val arrayList = arrayListOf<Pair>()
    println(arr.size)
    println(dep.size)

    for (i in arr.indices) {
        arrayList.add(Pair(arr[i], 'a'))
        arrayList.add(Pair(dep[i], 'd'))
    }

    arrayList.sortWith { (a, b), (a1, b1) ->
        if (a == a1) {
            b.compareTo(b1)
        } else a - a1
    }

    var currPlatforms = 0
    var maxPlatforms = 0

    for (i in arrayList.indices) {
        val curr = arrayList[i]
        if (curr.b == 'a') {
            currPlatforms++
            maxPlatforms = Math.max(currPlatforms, maxPlatforms)
        } else {
            currPlatforms--
        }
    }

    println("max platforms req = $maxPlatforms")
}

data class Pair(
    val a: Int,
    val b: Char
)
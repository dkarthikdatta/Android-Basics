package com.example.myapplication.repo


/**
 * 29. Data class in kotlin
 *
 * We often create classes to hold some data in it. In such classes, some standard functions are
 * often derivable from the data. In Kotlin, this type of class is known as data class and is marked as data.
 *
 * The compiler automatically derives the following functions :
 *
 * equals()
 * hashCode()
 * toString()
 * copy()
 */

fun main() {
    val myDataclass1: MyDataClass = MyDataClass(1, "Karthik")
    val myDataclass2: MyDataClass = MyDataClass(2, "Datta")

    val myNormalClass1: MyNormalClass = MyNormalClass(3, "Dinesh")
    val myNormalClass2: MyNormalClass = MyNormalClass(4, "Mandava")

    println(myDataclass1.toString())

    println(myNormalClass1.toString())
}
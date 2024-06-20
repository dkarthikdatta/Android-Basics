package com.example.myapplication.kotlin

import com.example.myapplication.repo.MyDataClass
import com.example.myapplication.repo.MyNormalClass


/**
 * 29. Data class in kotlin and scope functions
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
//
//    println(myDataclass1.toString()) // prints data
//
//    println(myNormalClass1.toString()) // prints class name
//
//    // all scope functions changes the data of the operating object
//    myDataclass1.let {
//        it.id = 100
//        println("printing last line in let")
//    }
//    println(myDataclass1)   // id becomes 100
//
//    myDataclass1.also {
//        it.id = 200
//    }
//    println(myDataclass1) // id becomes 200


    /**
     * let, run -> returns Lambda result (meaning last line)
     * apply, also -> returns object itself
     * with -> not a extension function -> doesn't returns anything
     */

    /**
     * let -> use for nullable objects
     */

    val letResult = myDataclass1?.let {
        it.id = 300
        "returning in let last line"
    }
    println(letResult)
    println(myDataclass1) // all scope functions changes the data of the operating object

    /**
     * run -> use to initialise the object and get the computation value in last line
     */
    val runResult = MyDataClass(400, "KD").run {
        id = 500 // initalizing other property in the object
        "this can be returned in run"
    }
    println(runResult)

    /**
     * apply -> mainly operate on the members of the receiver object. returns object itself
     * “apply the following assignments to the object"
     */

    val applyResult = myDataclass1.apply {
        id = 600
    }
    println(applyResult)
    println(myDataclass1) // all scope functions changes the data of the operating object

    /**
     * also -> where the actions are taken on the object rather than the fields of the object.
     * “and also do the following with the object.”
     */

    val alsoResult = myDataclass1.also {
        it.id = 700
        println(it.name)
    }
    println(alsoResult)
    println(myDataclass1) // all scope functions changes the data of the operating object
}
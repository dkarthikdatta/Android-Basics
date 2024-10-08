package com.example.myapplication.kotlin

import kotlin.reflect.KClass

fun main() {
    val inlineCrosslineReified = InlineCrosslineReified()
    inlineCrosslineReified.someFunction()
}


class InlineCrosslineReified {

    /**
     * 1. Inline
     *
     * simple def - at compile time, gets the function implementation code to the function calling place
     * only when the other function has some other function as parameter
     *
     * in normal way, when you send a function in parameter, new function object is created -> overhead
     * so, inline keyword copy pastes the code inside the calling function by compiler, which avoids creating a new function object
     * performance enhancement
     *
     * no need to add inline to function which doesn't contain function as input parameter
     * make only small functions as inline. not large functions as they generate more generated code
     *
     */

    fun someFunction() {
        println("hello, i am in start of other function")
        smallFunction {
            println("hello, this is part of function")
            println("hello, this is also part of function")
            val a = 3
        }
        println("hello, i am after other function")
    }

    private inline fun smallFunction(function: () -> Unit) {
        function()
    }

    /**
     * 2. noinline
     *
     * when using inline functions,
     * you can't reference input function os parameter or pass it in diff function
     *
     * case 1-> if we have multiple functions as input parameters, only one input function needs inline, make another noinline
     * case 2 -> if function have only one function input param -> dont do inline if you need to pass
     *
     */

    private inline fun incorrectUsageOfInline(action1: Int.() -> Unit) {
//        helperFunction { action1 } // this is not allowed
    }

    private fun helperFunction(action1: Int.() -> Unit) {

    }

    private inline fun anotherSmallFunction(
        noinline action1: Int.() -> Unit,
        action2: () -> Unit
    ) {
        action2()
        helperFunction2 { action1() } // this is allowed
    }

    private fun helperFunction2(action1: Int.() -> Unit) {

    }

    /**
     * 3. Crossline
     * if you want to reference input function, you can use crossline
     * something to do with return
     *
     */

    private inline fun anotherSmallFunction3(
        crossinline action1: Int.() -> Unit,
        action2: () -> Unit
    ) {
        action2()
        helperFunction3 { action1() } // this is allowed
    }

    private fun helperFunction3(action1: Int.() -> Unit) {

    }

    /**
     * 4. Reified
     * data type related
     */

    fun someMain() {
        makeSomething("string")
        makeSomething(2)
        makeSomething(2F)
    }

//    private fun <T> makeSomething(value: T) {
//        println("type of value is ${T::class.java}") // not possible
//    }

//    private fun <T: Any> makeSomething(value: T, type: KClass<T>) {
//        println("type of value is $type of value = $value") // manually pass the type
//    }


    // inline copies this code in calling function
    // hence gets information in the calling line
    private inline fun <reified T : Any> makeSomething(value: T) {
        println("type of value is ${T::class.java} of value = $value") // this is how reified to be used
    }

    // practical example
    // when we want to filer values

    inline fun <reified T : Any> List<Any>.filterSomething(): List<T> {
        return this.filter { it is T }.map { it as T }
    }
}

package com.example.myapplication.kotlin

fun main() {
    val normalClass1: NormalClass = NormalClass()
    val normalClass2: NormalClass = NormalClass()
    println(normalClass1.getNormalClass())
    println(NormalClass.getCompanionObject())
    println(normalClass2.getNormalClass())
    println(NormalClass.getCompanionObject())
}

class ClassObjectCompanionData {
}

class NormalClass() {

    companion object {
        const val a = 1
        fun getCompanionObject(): String {
            return a.toString() + this.toString()
        }
    }

    fun getNormalClass(): String {
        return "b $this"
    }
}

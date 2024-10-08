package com.example.myapplication.lazy


// initilaizes only once - value is computed only once
val synchronizedNumber by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { // by default normal lazy also synchronized
    println("Initialized")
    1.rangeTo(100).random()
}

// initialized every time but only first returned value is used for every lazy instance
val publicationNumber by lazy(LazyThreadSafetyMode.PUBLICATION) {
    println("Initialized")
    1.rangeTo(100).random()
}

// initializes for every thread and new value is returned.
val noneNumber by lazy(LazyThreadSafetyMode.NONE) {
    println("Initialized")
    1.rangeTo(100).random()
}

val defaultNumber by lazy {
    println("Initialized")
    1.rangeTo(100).random()
}


fun main() {
//    Thread { println(synchronizedNumber) }.start()
//    Thread { println(synchronizedNumber) }.start()

//    Thread { println(publicationNumber) }.start()
//    Thread { println(publicationNumber) }.start()

//    Thread { println(noneNumber) }.start()
//    Thread { println(noneNumber) }.start()

    Thread { println(defaultNumber) }.start()
    Thread { println(defaultNumber) }.start()

}

class lazyClass() {

}
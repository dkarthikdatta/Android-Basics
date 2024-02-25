package com.example.myapplication.coroutines.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * Coroutines are just like threads but not threads actually (called as light weight threads)
 * coroutines run on the top of threads -> framework over threads which automatically shifts threads
 *
 * Coroutines Scope -> defines lifetime
 * Coroutines Context -> defines to run on which thread
 * Dispatchers -> IO, Main, Default
 * Dispatchers -> Dispatch on which thread pool
 */

class MyCRViewModel {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            System.out.println("")
        }

    }
}
package com.example.myapplication.sdk

import android.content.Context
import kotlin.concurrent.Volatile


class MySDKkt private constructor() {
    fun sendEvent(studentName: String?, id: Int) {
        eventProcessor!!.processEvent(Student(id, studentName), id)
    }

    companion object {
        @Volatile
        private var INSTANCE: MySDKkt? = null
        private var myDb: MyDb? = null
        private var eventProcessor: EventProcessor? = null
        fun getINSTANCE(context: Context?): MySDKkt? {
            if (INSTANCE == null) {
                synchronized(MyDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = MySDKkt()
                        myDb = MyDb(context)
                        eventProcessor = EventProcessor(myDb)
                    }
                }
            }
            return INSTANCE
        }
    }
}


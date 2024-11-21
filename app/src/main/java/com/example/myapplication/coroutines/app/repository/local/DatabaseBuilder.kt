package com.example.myapplication.coroutines.app.repository.local

import android.content.Context
import androidx.room.Room

class DatabaseBuilder {

    private var INSTANCE: MyDatabase? = null

    fun getInstance(context: Context): MyDatabase {
        if (INSTANCE == null) {
            synchronized(MyDatabase::class) {
                if (INSTANCE == null) {
                    INSTANCE = buildRoomDB(context)
                }
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "learn-kotlin-flow"
        ).build()

}
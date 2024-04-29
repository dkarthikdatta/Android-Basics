package com.example.myapplication.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {
    //singleton needed to be used to initalize
    abstract fun contactDao(): ContactDao

}
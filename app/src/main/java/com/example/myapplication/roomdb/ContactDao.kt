package com.example.myapplication.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    // making all suspend in bg thread
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)



    //returning livedata ensures that the func is running in bg. no need of suspend
    @Query("SELECT * FROM contact")
    fun getAllContacts(): LiveData<List<Contact>>

}
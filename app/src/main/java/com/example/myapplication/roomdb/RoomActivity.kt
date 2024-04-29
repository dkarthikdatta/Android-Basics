package com.example.myapplication.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRoomBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {
    private lateinit var dataBase: ContactDataBase
    private lateinit var binding: ActivityRoomBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBase =
            Room.databaseBuilder(applicationContext, ContactDataBase::class.java, "contactDB")
                .build()

        CoroutineScope(Dispatchers.IO).launch {
            dataBase.contactDao().insertContact(Contact(0, "Karthik", "9493191713"))
        }

        dataBase.contactDao().getAllContacts().observe(this, Observer {
            it.forEach { contact ->
                binding.text.text = contact.name
            }
        })

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                dataBase.contactDao().insertContact(Contact(0, "Vishnu" + count.toString(), "1234"))
            }
            count++
        }
    }
}
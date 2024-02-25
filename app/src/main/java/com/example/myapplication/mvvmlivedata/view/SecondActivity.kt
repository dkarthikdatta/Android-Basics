package com.example.myapplication.mvvmlivedata.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.coroutines.view.ThirdActivity
import com.example.myapplication.databinding.ActivitySecondBinding
import com.example.myapplication.mvvmlivedata.view.vm.MyViewModelLiveData

class SecondActivity: AppCompatActivity() {

    // todo: Learn about adding activity in manifest file. how they add in stack. back click properties
    private lateinit var binding: ActivitySecondBinding
    lateinit var myViewModelLiveData: MyViewModelLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModelLiveData = ViewModelProvider(this).get(MyViewModelLiveData::class.java)
        myViewModelLiveData.factsLiveData.observe(this, Observer {
            binding.factsTectView.text = it
        })

        binding.btn.setOnClickListener {
            myViewModelLiveData.updateFactsData()
        }
        binding.next.setOnClickListener {
            val intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(intent)
        }

    }

}
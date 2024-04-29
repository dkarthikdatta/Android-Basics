package com.example.myapplication.machinecoding.parkinglot.models.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.machinecoding.parkinglot.models.vm.ParkingLotVMFactory
import com.example.myapplication.machinecoding.parkinglot.models.vm.ParkingLotViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var viewModel: ParkingLotViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, ParkingLotVMFactory()).get(ParkingLotViewModel::class.java)

        binding.button.setOnClickListener {
            binding.input.text.toString().let {
                viewModel.onInput(it)
            }
        }
        viewModel.onOutputChange.observe(this, Observer {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
//            println("Learn" + it)
            Log.d("Learn", it)
        })

    }
}
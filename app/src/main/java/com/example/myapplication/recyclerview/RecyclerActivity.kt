package com.example.myapplication.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val flowerList = applicationContext.resources.getStringArray(R.array.flower_array)
        println("Teest " + flowerList.size)
        for(i in flowerList.indices){
            println("Teest " + flowerList[i] + " ")
        }
//        flowerAdapter.notifyDataSetChanged()
        binding.recyclerView.adapter = FlowerAdapter(flowerList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
package com.example.myapplication.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class CustomAdapter(val list: ArrayList<Int>) : RecyclerView.Adapter<MyCustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent, false)
        return MyCustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val childView = itemView.findViewById<TextView>(R.id.flower_text)
    fun bind(data: Int){
        childView.text = data.toString()
    }
}
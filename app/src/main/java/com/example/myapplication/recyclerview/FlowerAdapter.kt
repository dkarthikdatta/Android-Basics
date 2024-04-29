package com.example.myapplication.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class FlowerAdapter(private val list: Array<String>) :
    RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

    init {
        println("Teest in inside Adapter, list size = " + list.size )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        println("Teest in onCreateViewHolder" + list + " ")
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return FlowerViewHolder(view);
    }

    override fun getItemCount(): Int {
        println("teest on getItemCount, list size = " + list.size)
        return list.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        println("Teest in onBindViewHolder" + list[position] + " ")
        holder.bind(list[position])
    }

    class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val individualViews: TextView = itemView.findViewById(R.id.flower_text)
        fun bind(data: String) {
            println("Teest in bind" + data + " ")
            individualViews.text = data
        }
    }
}



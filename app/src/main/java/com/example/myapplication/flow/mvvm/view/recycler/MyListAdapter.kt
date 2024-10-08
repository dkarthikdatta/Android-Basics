package com.example.myapplication.flow.mvvm.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.flow.mvvm.model.Category

class MyListAdapter : ListAdapter<Category, MyListAdapter.MyViewHolder>(CategoryDiffUtil()) {


    class MyViewHolder(view: View) : ViewHolder(view) {
        private val title: TextView = view.findViewById<TextView>(R.id.flower_text)
        private val body: TextView = view.findViewById<TextView>(R.id.content_text)
        private val id: TextView = view.findViewById<TextView>(R.id.id)
        fun onBind(category: Category) {
            category.let {
                id.text = it.id.toString()
                title.text = it.category
                body.text = it.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
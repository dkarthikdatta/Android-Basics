package com.example.myapplication.recycleViewActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.repo.Quote

class MyListAdapter : ListAdapter<Quote, MyListAdapter.MyViewHolder>(MyDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }


    class MyViewHolder(view: View) : ViewHolder(view) {
        val author = view.findViewById<TextView>(R.id.flower_text)
        val content = view.findViewById<TextView>(R.id.content_text)

        fun bindView(data: Quote) {
            author.text = data.author
            content.text = data.text
        }
    }

}
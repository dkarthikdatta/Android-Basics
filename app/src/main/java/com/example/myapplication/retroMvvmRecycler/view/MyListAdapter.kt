package com.example.myapplication.retroMvvmRecycler.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.repo.Quote
import com.example.myapplication.retroMvvmRecycler.network.MovieDataItem

class MyListAdapter : ListAdapter<MovieDataItem, MyListAdapter.MyViewHolder>(MyDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }


    class MyViewHolder(view: View) : ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.flower_text)
        val body = view.findViewById<TextView>(R.id.content_text)
        val id = view.findViewById<TextView>(R.id.id)

        fun bindView(data: MovieDataItem) {
            title.text = data.title
            body.text = data.body
            id.text = data.id.toString()
        }
    }

}
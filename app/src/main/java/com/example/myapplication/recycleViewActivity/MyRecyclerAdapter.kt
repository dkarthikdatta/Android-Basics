package com.example.myapplication.recycleViewActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.repo.Quote
import java.util.ArrayList

class MyRecyclerAdapter(val list: List<Quote>) :
    RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.onBind(list[position])
    }

//    fun updateData(data: ArrayList<Int>) {
//        TODO("Not yet implemented")
//    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val authorView = itemView.findViewById<TextView>(R.id.flower_text)
        val contentView = itemView.findViewById<TextView>(R.id.content_text)
        fun onBind(data: Quote) {
            authorView.text = data.author
            contentView.text = data.text
        }
    }
}
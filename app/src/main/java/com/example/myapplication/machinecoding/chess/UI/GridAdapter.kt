package com.example.myapplication.machinecoding.chess.UI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.R

class GridAdapter(context: Context, pieces: ArrayList<String?>) :
    ArrayAdapter<String?>(context, 0, pieces) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listItemView = convertView
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView = LayoutInflater.from(context).inflate(R.layout.chess_item, parent, false)
        }

        val piece: String? = getItem(position)
        val pieceView = listItemView!!.findViewById<TextView>(R.id.piece)

        pieceView.text = piece
        return listItemView
    }
}
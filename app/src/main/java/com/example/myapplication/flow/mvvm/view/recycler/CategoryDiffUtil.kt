package com.example.myapplication.flow.mvvm.view.recycler

import android.media.browse.MediaBrowser.ItemCallback
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.flow.mvvm.model.Category

class CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}
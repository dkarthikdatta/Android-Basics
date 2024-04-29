package com.example.myapplication.recycleViewActivity

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.repo.Quote

class MyDiffUtil: DiffUtil.ItemCallback<Quote>(){


    /**
     * areItemsTheSame - used to determine structural changes between
     *                  old and new list (additions/removals/position changes)
     *
     * areContentsTheSame - determines if particular item was updated
     *
     * areItemsTheSame - checks some id in old and new data.
     *                  if false -> direct add to diff
     *                  if true -> since id is same, the content
     *                  of data may have updated. check areContentsTheSame
     *
     * areContentsTheSame - check the content of old and new data
     *                      if false -> update the new data object. call getChangePayload(T oldItem, T newItem)
     *                      if true -> do nothing
     *
     */
    override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem == newItem;
    }

}
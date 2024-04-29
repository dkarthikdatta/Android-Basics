package com.example.myapplication.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecyclerItemBinding
import com.example.myapplication.repo.Quote

/**
 * Data displayed by the recyclerview is constantly changing due to the deletion of data and the
 * addition of new data. To observe these changes in the UI, we have to call notifyDataSetChanged.
 *
 * notifyDataSetChanged recreates all the views and then displays a list with the most recent changes;
 * notifyDataSetChanged works well, but for a recyclerview with a high number of items, the process
 * will consume a lot of time and might cause your app to freeze. To solve this problem, DiffUtil was created.
 *
 * DiffUtil is a utility class that calculates the difference between two lists and outputs a list
 * of update operations that converts the first list into the second one.
 * DiffUtils is based on Eugene Myers’ algorithm. -Android Official Documentation
 *
 *
 * We will use AsyncListDiffer, a DiffUtil helper that calculates the difference between two lists
 * on a background thread. After calculating the difference, it signals the adapter of the changes
 * in the two lists.
 *
 * or just use ListAdapter which internally contains AsyncListDiffer.
 */
class MyDiffUtilAdapter : RecyclerView.Adapter<MyDiffUtilAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(quote: Quote) {
            binding.flowerText.text = quote.author
        }
    }

    val diffUtil = object : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem.author == newItem.author
        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem == newItem
        }

    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    fun saveData(quoteList: List<Quote>) {
        asyncListDiffer.submitList(quoteList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(asyncListDiffer.currentList[position])
    }
}
package com.example.myapplication.recycleViewActivity

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityRecyclerViewBinding
import com.example.myapplication.repo.Quote

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val quote = Quote("A", "BC")
        val data: List<Quote> = listOf(
            Quote("ABC", "A"),
            Quote("DEF", "B"),
            Quote("GHI", "C")
        )
        val adapter: MyRecyclerAdapter = MyRecyclerAdapter(data)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        binding.recyclerView.apply {
//            this.layoutManager = layoutManager // imp - horizontal, vertical, staggered
//            this.adapter = adapter
//        }

        //update data using notifyDataSetChanged
        // update data object which is used to send the data.
//        binding.normalAdapter.setOnClickListener {
//            data.add(Quote("JKL", "D"))
//            data.add(Quote("MNO", "E"))
//            data.add(Quote("PQR", "F"))
////            adapter.updateData(data)
//            adapter.notifyDataSetChanged()
//        }
//        binding.recyclerView.adapter = adapter
//        adapter.notifyDataSetChanged()


        val listAdapter = MyListAdapter()
        binding.recyclerView.apply {
            this.layoutManager = layoutManager // imp - horizontal, vertical, staggered
            this.adapter = listAdapter
        }

        listAdapter.submitList(data)

        binding.listAdapter.setOnClickListener {
            val data2 = listOf(
                Quote("ABC", "A"),
                Quote("DEF", "B"),
                Quote("GHI", "C"),
                Quote("BCD", "J")
            )
//            data.add(Quote("STU", "G"))
//            data.add(Quote("VWX", "H"))
//            data.add(Quote("YZA", "I"))
            listAdapter.submitList(data2)   //submit a new list
        }
    }
}

package com.example.myapplication.retroMvvmRecycler.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.myapplication.databinding.ActivityMyMainBinding
import com.example.myapplication.retroMvvmRecycler.network.MainRepository
import com.example.myapplication.retroMvvmRecycler.network.RetrofitService
import com.example.myapplication.retroMvvmRecycler.vm.MyViewModel
import com.example.myapplication.retroMvvmRecycler.vm.MyViewModelFactory

class MyMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyMainBinding
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = MainRepository(RetrofitService.getInstance())

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(repository)).get(MyViewModel::class.java)

        val adapter = MyListAdapter()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = VERTICAL

        binding.recyclerView.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

        viewModel.moviesLiveData.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.getMovies()
    }
}
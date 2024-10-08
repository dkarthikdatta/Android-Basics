package com.example.myapplication.flow.mvvm.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.myapplication.databinding.ActivityFlowCoroutineBinding
import com.example.myapplication.flow.mvvm.api.ApiHelperImpl
import com.example.myapplication.flow.mvvm.api.ApiService
import com.example.myapplication.flow.mvvm.db.DBHelperImpl
import com.example.myapplication.flow.mvvm.db.dbRelated.DatabaseBuilder
import com.example.myapplication.flow.mvvm.repository.Repository
import com.example.myapplication.flow.mvvm.view.recycler.MyListAdapter
import com.example.myapplication.flow.mvvm.vm.GenericViewModel
import com.example.myapplication.flow.mvvm.vm.GenericViewModelFactory
import kotlinx.coroutines.launch

class FlowCoroutineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlowCoroutineBinding
    private lateinit var genericViewModel: GenericViewModel
    private lateinit var repository: Repository
    private lateinit var recyclerAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerAdapter = MyListAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = VERTICAL

        binding.recyclerView.apply {
            this.layoutManager = layoutManager
            this.adapter = recyclerAdapter
        }

        repository = Repository(
            ApiHelperImpl(ApiService.RetrofitBuilder.apiService),
            DBHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        )

        genericViewModel =
            ViewModelProvider(
                this,
                GenericViewModelFactory(repository, false)
            ).get(GenericViewModel::class.java)


        // since need to collect data in activity, and collect is suspend function,
        // need a coroutine to be launched on main thread. since main  coroutine,
        // if activity is recreated, again listen - not sure
        // - own lifecycle handling
//        lifecycleScope.launch {
//            genericViewModel.categoryStateFlow.collect {
//                println("TEST_KD, setting data from categoryStateFlow")
//                recyclerAdapter.submitList(it)
//            }
//        }
//
//        // can handle flow data like this also using live data
//        genericViewModel.categoryLiveDataFromFlow.observe(this, Observer {
//            println("TEST_KD, setting data from categoryLiveDataFromFlow")
//            recyclerAdapter.submitList(it)
//        })


        // coroutine
        genericViewModel.categoryLiveData.observe(this, Observer {
            println("TEST_KD, setting data from categoryLiveData")
            recyclerAdapter.submitList(it)
        })
        genericViewModel.errorMsgLiveData.observe(this, Observer {
//            println("TEST_KD, setting data from categoryLiveData")
//            recyclerAdapter.submitList(it)
        })
        genericViewModel.loaderLiveData.observe(this, Observer {
            if (it) {
                println("TEST_KD, showing loader")
                binding.loader.visibility = View.VISIBLE
            } else {
                println("TEST_KD, hiding loader")
                binding.loader.visibility = View.GONE
            }
        })

    }
}
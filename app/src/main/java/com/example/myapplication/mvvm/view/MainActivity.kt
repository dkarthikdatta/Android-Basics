package com.example.myapplication.mvvm.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.mvvm.view.vm.MyViewModel
import com.example.myapplication.mvvm.view.vm.MyViewModelFactory
import com.example.myapplication.mvvmlivedata.view.SecondActivity
import com.example.myapplication.mvvmlivedata.view.vm.MyViewModelLiveData
import com.example.myapplication.repo.Quote

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var myViewModeLiveData: MyViewModelLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // default without params, without viewmodelfactory
//        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // with init params, by viewmodelfactory
        myViewModel = ViewModelProvider(this, MyViewModelFactory(applicationContext)).get(
            MyViewModel::class.java)
        setQuote(myViewModel.getQuote())
        binding.nextButton.setOnClickListener {
            setQuote(myViewModel.nextQuote())
        }

        binding.floatingActionButton.setOnClickListener {
            // implicit intent
            // todo: read about put extra, bundle, intent, startActivity
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, myViewModel.getQuote().text)
            startActivity(intent)
        }

        // putExtra vs putExtras - Bundle https://stackoverflow.com/a/15243947
        binding.nextPage.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }

    }
    fun setQuote(quote: Quote){
        binding.quoteText.text = quote.text
        binding.quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View){
        setQuote(myViewModel.prevQuote())
    }

}
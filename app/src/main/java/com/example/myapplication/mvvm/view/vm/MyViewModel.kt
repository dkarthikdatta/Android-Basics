package com.example.myapplication.mvvm.view.vm
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.myapplication.repo.Quote
import com.google.gson.Gson

/**
 * ViewModel class is needed to extend to create a view model
 * but this cant take arguments to initalize VM with a value by constructor
 * Hence ViewModelFactory is required
 *
 * view reference cant be passed into viewmodel
 * but view context can be passed
 *
 * Livedata -> observable dataholder.
 * if there are any changes in LiveData, a callback is automatically made
 * LiveData -> LifeCycle Aware -> notifies only to active components
 *
 */
class MyViewModel(val context: Context) : ViewModel() {

    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0;

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = if(index != quoteList.size-1) quoteList[++index] else quoteList[index]

    fun prevQuote() = if(index != 0) quoteList[--index] else quoteList[0]

}
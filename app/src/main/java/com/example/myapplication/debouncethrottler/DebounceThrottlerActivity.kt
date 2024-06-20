package com.example.myapplication.debouncethrottler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import androidx.core.widget.doOnTextChanged
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDebounceThrottlerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

class DebounceThrottlerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDebounceThrottlerBinding
    private val debounce = Debounce()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebounceThrottlerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.editText.doOnTextChanged { text, start, before, count ->
            debounce.debounce<String>(
                1000,
                CoroutineScope(Dispatchers.Main),
                ::addDebounceText
            )(text.toString())
//            debounce.throttleFirst<String>(
//                4000,
//                CoroutineScope(Dispatchers.Main),
//                ::addTrottleFirstText
//            )
            debounce.throttleLatest<String>(
                1000,
                CoroutineScope(Dispatchers.Main),
                ::addTrottleLastText
            )(text.toString())
        }

    }

    private fun addDebounceText(text: String) {
        binding.debounceText.text = text
    }


    private fun addTrottleFirstText(s: String) {
        binding.throttleFirst.text = s
    }

    private fun addTrottleLastText(s: String) {
        binding.throttleLatest.text = s
    }
}


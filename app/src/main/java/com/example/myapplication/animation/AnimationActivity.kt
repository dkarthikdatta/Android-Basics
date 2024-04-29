package com.example.myapplication.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(binding.fragmentContainerView.id, BlinkFragment.newInstance())
            ft.addToBackStack(null)
            ft.commit()
        }
    }
}
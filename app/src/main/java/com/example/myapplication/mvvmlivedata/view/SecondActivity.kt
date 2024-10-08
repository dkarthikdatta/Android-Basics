package com.example.myapplication.mvvmlivedata.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.coroutines.view.CoroutineActivity
import com.example.myapplication.databinding.ActivitySecondBinding
import com.example.myapplication.mvvm.view.MainActivity
import com.example.myapplication.mvvmlivedata.view.vm.MyViewModelLiveData
import java.text.DecimalFormat
import java.text.NumberFormat

class SecondActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    lateinit var myViewModelLiveData: MyViewModelLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModelLiveData = ViewModelProvider(this).get(MyViewModelLiveData::class.java)
        myViewModelLiveData.factsLiveData.observe(this, Observer {
            binding.factsTectView.text = it
        })


        binding.btn.setOnClickListener {
            myViewModelLiveData.updateFactsData()
        }
        binding.next.setOnClickListener {
            val intent = Intent(applicationContext, CoroutineActivity::class.java)
            startActivity(intent)
        }

        binding.toast.setOnClickListener {
            myViewModelLiveData.onToastClicked()
        }


        val countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val f: NumberFormat = DecimalFormat("00")
                val hour = millisUntilFinished / 3600000 % 24
                val min = millisUntilFinished / 60000 % 60
                val sec = millisUntilFinished / 1000 % 60
                binding.coutdown.text = f.format(hour) + ":" + f.format(min) + ":" + f.format(sec)
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }

        binding.start.setOnClickListener {
            countDownTimer.start()
        }
        binding.stop.setOnClickListener {
            countDownTimer
            countDownTimer.cancel()
        }




        /**
         * yes, without singleLiveEvent, by just using livedata and mutablelivedata,
         * toast is appearing on screen rotation.
         * rotation -> activity recreated -> onCreate is called again
         */

        myViewModelLiveData.getToastMsg.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        /**
         * Explicit intents are used when you want to explicitly specify the
         * exact component (activity, service, or broadcast receiver) to be
         * invoked. You precisely define the target component within your code.
         */

        binding.explicit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /**
         *  Implicit intents are used when you want to describe a general action
         *  to be performed, leaving it to the Android system to determine which
         *  component should handle the action based on its capabilities
         *  and the filter criteria specified in the intent.
         *
         *  Implicit intents are commonly employed for actions like sending an
         *  email, opening a web page, making a phone call, or sharing content.
         *  You don't need to specify a particular component; instead,
         *  the Android system presents the user with a list of apps capable
         *  of handling the requested action.
         */
        binding.implicit.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT,"I am the the that is getting shared")
            startActivity(Intent.createChooser(intent, "Share via"))
        }

        val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.car)
        binding.imageView.setImageBitmap(bitmap1)
    }

}
package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class SecondFragment: Fragment() {

    val TAG = "LEARN_FRAGMENT"
    val TAG_FRAG = " In 2nd Fragment "

    private var someString: String? = null
    private var someInt: Int? = null
    companion object{
        public fun newInstance(someInputString: String?, someInputInt: Int?): SecondFragment{
            val args = Bundle()
            if (someInputInt != null) {
                args.putInt("someInt", someInputInt)
            }
            args.putString("someString", someInputString)
            val fragment = SecondFragment()
            fragment.arguments = args
            return fragment
        }
    }

    /**
     * savedInstanceState -> if not null, fragment recreates automatically
     * get the args here
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        someString = arguments?.getString("someString")
        someInt = arguments?.getInt("someInt")
        println(TAG + TAG_FRAG + "onCreate")
    }

    /**
     * this is where to inflate the view of fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println(TAG + TAG_FRAG + "onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false) // always false for fragments
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(TAG + TAG_FRAG + "onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        println(TAG + TAG_FRAG + "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        println(TAG + TAG_FRAG + "onStart")
    }

    override fun onResume() {
        super.onResume()
        println(TAG + TAG_FRAG + "onResume")
    }

    override fun onPause() {
        super.onPause()
        println(TAG + TAG_FRAG + "onPause")
    }

    override fun onStop() {
        super.onStop()
        println(TAG + TAG_FRAG + "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println(TAG + TAG_FRAG + "onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println(TAG + TAG_FRAG + "onDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        println(TAG + TAG_FRAG + "onDestroy")
    }

}
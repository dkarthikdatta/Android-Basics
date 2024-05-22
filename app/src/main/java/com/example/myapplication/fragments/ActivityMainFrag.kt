package com.example.myapplication.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityMainFragBinding

class ActivityMainFrag: AppCompatActivity() {
    private lateinit var binding: ActivityMainFragBinding
    val TAG = "LEARN_FRAGMENT"
    val TAG_FRAG = " In Activity "
    var firstAddToBackStack = false;
    var addOrReplace = "add"
    var addToBackStack = false
    var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragment.setOnClickListener {
            if(count%3==1){
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                val fragment: FirstFragment = FirstFragment.newInstance("Karthik", 24)
//                if(addOrReplace == "add") {
//                    ft.add(binding.fragmentContainerView.id, fragment)
//                } else {
//                    ft.replace(binding.fragmentContainerView.id, fragment)
//                }
                ft.add(binding.fragmentContainerView.id, fragment)
//                ft.addToBackStack(null)
                if(addToBackStack){
                    ft.addToBackStack(null)
                }
                ft.commit()
            } else if(count%3==2){
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                val fragment: SecondFragment = SecondFragment.newInstance("Karthik", 24)
//                if(addOrReplace == "add") {
//                    ft.add(binding.fragmentContainerView.id, fragment)
//                } else {
//                    ft.replace(binding.fragmentContainerView.id, fragment)
//                }
                ft.add(binding.fragmentContainerView.id, fragment)
//                ft.addToBackStack(null)
                if(addToBackStack){
                    ft.addToBackStack(null)
                }
                ft.commit()
            } else {
                val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
                val fragment: ThirdFragment = ThirdFragment.newInstance("Karthik", 24)
//                if(addOrReplace == "add") {
//                    ft.add(binding.fragmentContainerView.id, fragment)
//                } else {
//                    ft.replace(binding.fragmentContainerView.id, fragment)
//                }
                ft.replace(binding.fragmentContainerView.id, fragment)
//                ft.addToBackStack(null)
                if(addToBackStack){
                    ft.addToBackStack(null)
                }
                ft.commit()
            }
            count++;
        }
    }

    /**
     *
     * https://stackoverflow.com/questions/18634207/difference-between-add-replace-and-addtobackstack
     *
     * and and replace -> no direct connection whether previous fragments/activity SHOWS on back press
     *
     * add ->
     * just adds the current fragment over previous fragment/activity.
     * current adding fragment onCreate, onCreateView, onViewCreated, onViewStateRestored, onStart, onResume
     * are called. Nothing will happen to previous fragments
     *
     *
     * replace -> remove and add
     * removes all the previous fragments. removes means lifecycle related. Not to backbutton/transaction (i.e., removing does not mean that previous fragments wont come on back press. this is related to back stack)
     * removing all the previous fragments means, onPause, onStop, onDestroyView of ALL previous fragments are called
     * adds current fragments -> onCreate, onCreateView, onViewCreated, onViewStateRestored, onStart, onResume of current fragment are called
     *
     *
     * addToBackStack
     * false -> does not add the current transaction to the stack
     * regardless of add or replace, if current transaction is not added ToBackStack, it wont appear while going back
     *
     *
     * add to back stack the first fragment attaching to activity
     */
}
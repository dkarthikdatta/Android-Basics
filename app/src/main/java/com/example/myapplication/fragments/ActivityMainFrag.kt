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
     * add to back stack the first fragment attaching to activity
     */


    /**
     * commit vs commitAllowingStateloss
     *
     * if transaction commits after onSavedInstance of activity, IllegalStateException is thrown
     * reason -> at onSavedInstance, activity tries to save the snapshot of activity by bundle
     * if commit is called after onSavedInstance, the transaction won’t be remembered because it was never recorded as part of the Activity’s state in the first place.
     * In order to protect the user experience, Android avoids state loss at all costs, and simply throws an IllegalStateException whenever it occurs.
     *
     * commitAllowingStateloss
     * You might lose the FragmentManager’s state and by extension the state of any Fragments added or removed since onSaveInstanceState().
     *
     * Here’s a practical example:
     * Your Activity is displayed and is currently showing FragmentA
     * Your Activity is sent to the background (onStop() and onSaveInstanceState() are called)
     * In response to some sort of event, you replace FragmentA with FragmentB and call commitAllowingStateLoss().
     *
     */

    /**
     * commit vs commitNow
     *
     * Schedules a commit of this transaction. The commit does not happen immediately; it will be scheduled as work on the main thread to be done the next time that thread is ready.
     * same with  popBackStack().
     *
     * But if you want to commit this transaction immediately, use commitNow - same with popBackStackImmediate()
     * Earlier, executePendingTransactions was used which  will take all those transactions that you currently have queued up and will process them immediately.
     * Now, commitNow only executes the current transaction synchronously.
     *
     *  can't add to backStack if you are using commitNow as  framework can’t provide any guarantees regarding the ordering here, it simply isn’t supported.
     *
     */
}
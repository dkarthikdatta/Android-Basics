package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class FirstFragment : Fragment() {

    val TAG = "LEARN_FRAGMENT"
    val TAG_FRAG = " In 1st Fragment "

    private var someString: String? = null
    private var someInt: Int? = null

    companion object {
        @JvmStatic
        public fun newInstance(someInputString: String, someInputInt: Int): FirstFragment{
            val args = Bundle()
            args.putInt("someInt", someInputInt)
            args.putString("someString", someInputString)
            val fragment = FirstFragment()
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
        return inflater.inflate(R.layout.fragment_first, container, false) // always false for fragments
    }

    /**
     * inflate params ->
     *
     * https://stackoverflow.com/a/45809756
     * inflater.inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
     *
     * NOW OR NOT NOW
     * The main difference between the "third" parameter attachToRoot being true or false is this.
     *
     * When you put attachToRoot
     *
     * true : add the child view to parent RIGHT NOW
     * false: add the child view to parent NOT NOW.
     * Add it later. `
     *
     * When is that later?
     *
     * That later is when you use eg parent.addView(childView)
     *
     * A common misconception is, if attachToRoot parameter is false then the child view will not be added to parent. WRONG
     * In both cases, child view will be added to parentView. It is just a matter of time.
     *
     * inflater.inflate(child,parent,false);
     * parent.addView(child);
     *
     * is equivalent to
     *
     * inflater.inflate(child,parent,true);
     *
     * A BIG NO-NO
     *
     * You should never pass attachToRoot as true when you are not responsible for adding the child view to the parent.
     * Eg When adding Fragment and (Recycler view?)
     *
     * public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle bundle)
     *   {
     *         super.onCreateView(inflater,parent,bundle);
     *         View view = inflater.inflate(R.layout.image_fragment,parent,false);
     *         .....
     *         return view;
     *   }
     * if you pass third parameter as true you will get IllegalStateException because of this guy.
     *
     * getSupportFragmentManager()
     *       .beginTransaction()
     *       .add(parent, childFragment)
     *       .commit();
     *
     * Since you have already added the child fragment in onCreateView() by mistake, calling add will tell you that child view is already added to the parent Hence IllegalStateException.
     * Here you are not responsible for adding childView, FragmentManager is responsible. So always pass false in this case.
     *
     * NOTE: I have also read that parentView will not get childView touchEvents if attachToRoot is false. But I have not tested it though.
     *
     */


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
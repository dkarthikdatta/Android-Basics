package com.example.myapplication.broadcastReceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class BroadCastReceiverActivity : AppCompatActivity() {

    val myBroadCastReceiver = MyBroadCastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast_receiver)
        registerReceiver(myBroadCastReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}

//MyBroadcastReceiver class should be common and mandatory in both dynamically and statically broadcast receivers -> implies what to dp

// register broadcast receiver dynamically
/**
 * registerReceiver(myBroadCastReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)) in some activity
 */

// register broadcast receiver statically
/**
 * <receiver android:name=".MyBroadcastReceiver"  android:exported="true">
 *     <intent-filter>
 *         <action android:name="android.net.conn.CONNECTIVITY_CHANGE""/>
 *
 *     </intent-filter>
 * </receiver>
 */


// send broadcast to other apps dynamically

/**
 * Intent intent = new Intent();
 * intent.setAction("com.example.broadcast.MY_NOTIFICATION");
 * intent.putExtra("data", "Nothing to see here, move along.");
 * sendBroadcast(intent);
 * //With permissions
 * sendBroadcast(new Intent("com.example.NOTIFY"),
 *               Manifest.permission.SEND_SMS);
 *
 * //the receiving app must request the permission
 * <uses-permission android:name="android.permission.SEND_SMS"/>
 */

// to send broadcast to other apps statically, add package name of destination app along with intent.
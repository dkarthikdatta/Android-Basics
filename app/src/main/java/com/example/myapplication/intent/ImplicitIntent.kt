package com.example.myapplication.intent

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Explicit intent -> Explicit intents are used in the application itself wherein one activity can switch to other activity.
// Implicit Intent -> Implicit Intents do not directly specify the Android components which should be called, it only specifies action to be performed. A Uri can be used with the implicit intent to specify the data type.
class ImplicitIntentActivity : AppCompatActivity() {

    // To share text from our app to any app that supports text income
    fun shareText(textToShare: String) {
        val shareIntent: Intent = Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);

        // Verify that the Intent can be resolved to an Activity
        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        } else {
            // Handle the case where no activity can handle the share intent
            Toast.makeText(this, "No app found to handle sharing", Toast.LENGTH_SHORT).show();
        }
    }


    // To accept text from other applications
    /**
     * Register intent-filter in AndroidManifest.xml file
     * <activity ...>
     *     <intent-filter>
     *         <action android:name="android.intent.action.SEND" />
     *         <category android:name="android.intent.category.DEFAULT" />
     *         <data android:mimeType="text/plain" />
     *     </intent-filter>
     * </activity>
     *
     * Intent receivedIntent = getIntent();
     * String sharedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);
     * // Process the shared text
     *
     */

    /**
     * Different actions that are supported are
     *
     * ACTION_VIEW
     * ACTION_EDIT
     * ACTION_PICK
     * ACTION_SENDTO
     * ACTION_CALL
     * ACTION_DIAL
     */


}
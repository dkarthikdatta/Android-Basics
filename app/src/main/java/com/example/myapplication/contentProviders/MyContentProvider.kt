package com.example.myapplication.contentProviders

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import javax.annotation.Nullable


//Creating My own Content Provider:
class MyContentProvider : ContentProvider() {
    // Override ContentProvider methods
    override fun onCreate(): Boolean {
        // Initialize your Content Provider here
        return true
    }

    @Nullable
    override fun query(
        uri: Uri, @Nullable projection: Array<String?>?, @Nullable selection: String?,
        @Nullable selectionArgs: Array<String?>?, @Nullable sortOrder: String?
    ): Cursor? {
        // Handle query operation here
        return null
    }

    @Nullable
    override fun insert(uri: Uri, @Nullable values: ContentValues?): Uri? {
        // Handle insert operation here
        return null
    }

    override fun update(
        uri: Uri, @Nullable values: ContentValues?, @Nullable selection: String?,
        @Nullable selectionArgs: Array<String?>?
    ): Int {
        // Handle update operation here
        return 0
    }

    override fun delete(
        uri: Uri,
        @Nullable selection: String?,
        @Nullable selectionArgs: Array<String?>?
    ): Int {
        // Handle delete operation here
        return 0
    }

    @Nullable
    override fun getType(uri: Uri): String? {
        // Return the MIME type of the data
        return null
    }

    companion object {
        // Define constants for URIs and column names
        const val AUTHORITY = "com.example.myapp.provider"
        val CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/data")
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "name"
    }

}


//register this in AndroidManifest.xml file

/**
 * <manifest xmlns:android="http://schemas.android.com/apk/res/android"
 *     package="com.example.myapp">
 *
 *     <application
 *         android:allowBackup="true"
 *         android:icon="@mipmap/ic_launcher"
 *         android:label="@string/app_name"
 *         android:theme="@style/AppTheme">
 *
 *         <!-- Other application components -->
 *
 *         <!-- Define your Content Provider -->
 *         <provider
 *             android:name=".MyContentProvider"
 *             android:authorities="com.example.myapp.provider"
 *             android:exported="true">
 *         </provider>
 *
 *     </application>
 *
 * </manifest>
 */


//accessing content provider of other app
/**
 *
 * // Construct the URI for the Content Provider
 * Uri uri = Uri.parse("content://com.example.myapp.provider/data");
 *
 * // Retrieve the Content Resolver
 * ContentResolver resolver = context.getContentResolver();
 *
 * // Perform a query operation on the Content Provider
 * Cursor cursor = resolver.query(uri, null, null, null, null);
 *
 * // Process the results of the query
 * if (cursor != null) {
 *     while (cursor.moveToNext()) {
 *         // Process each row of the query result
 *     }
 *     cursor.close();
 * }
 *
 */

//accessing content provider of contacts
/**
 * private fun fetchContacts() {
 *
 *         val resolver: ContentResolver = contentResolver
 *         val cursor = resolver.query(
 *             ContactsContract.Contacts.CONTENT_URI,
 *             null, null, null, null
 *         )
 *         if (cursor!!.count > 0) {
 *             while (cursor.moveToNext()) {
 *                 val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
 *                 val name =
 *                     cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
 *                 val phoneNum =
 *                     cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
 *                         .toInt()
 *                 if (phoneNum > 0) {
 *                     val cursorPhone = contentResolver.query(
 *                         ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
 *                         null,
 *                         ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " =?",
 *                         arrayOf(id),
 *                         null
 *                     )
 *                     if (cursorPhone!!.count > 0) {
 *                         while (cursorPhone.moveToNext()) {
 *                             val phoneNumValue = cursorPhone.getString(
 *                                 cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
 *                             )
 *                             contactsStr.add("$name|$phoneNumValue")
 *                         }
 *                     }
 *                     cursorPhone.close()
 *
 *                 }
 *             }
 *         }
 */
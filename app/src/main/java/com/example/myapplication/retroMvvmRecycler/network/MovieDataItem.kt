package com.example.myapplication.retroMvvmRecycler.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable
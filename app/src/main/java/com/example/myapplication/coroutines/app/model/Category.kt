package com.example.myapplication.coroutines.app.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class CategoryResponse(
    @SerializedName("categories")
    val categoryResponse: List<Category>
) : Parcelable

@Parcelize
@Entity
data class Category(
    @SerializedName("idCategory")
    @PrimaryKey val id: Int = 0,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCategoryThumb")
    val imgUrl: String = "",
    @SerializedName("strCategoryDescription")
    val description: String = ""
) : Parcelable

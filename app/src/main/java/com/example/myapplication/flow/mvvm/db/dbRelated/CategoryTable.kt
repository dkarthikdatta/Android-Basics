package com.example.myapplication.flow.mvvm.db.dbRelated

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "category")
data class CategoryTable(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "category") val name: String?,
    @ColumnInfo(name = "imgUrl") val imgUrl: String?,
    @ColumnInfo(name = "description") val description: String?
)

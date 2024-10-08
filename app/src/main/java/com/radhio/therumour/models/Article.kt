package com.radhio.therumour.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: @RawValue Source? = null,
    val title: String,
    val url: String,
    val urlToImage: String
) : Parcelable
package com.example.project.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    val category: String,
    val `data`: List<Data>,
    val success: Boolean
):Parcelable
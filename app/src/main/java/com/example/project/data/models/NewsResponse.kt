package com.example.project.data.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val `articles`: List<Data>,
    var category: String = "",
):Parcelable
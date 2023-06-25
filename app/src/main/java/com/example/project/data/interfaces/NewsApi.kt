package com.example.project.data.interfaces

import com.example.project.data.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country")country:String = "us",
        @Query("category")category:String,
        @Query("apiKey")apiKey:String = "549bc36d2ee94a31b99b79d534853202",
    ):NewsResponse
}
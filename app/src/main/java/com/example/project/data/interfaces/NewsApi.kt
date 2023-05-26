package com.example.project.data.interfaces

import com.example.project.data.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNews(@Query("category")category:String):NewsResponse
}
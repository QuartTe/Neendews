package com.example.project.data.repo

import com.example.project.data.factories.NewsApiFactory
import com.example.project.data.models.NewsResponse

object NewsRepo {
    suspend fun getNews(category:String): NewsResponse{

        val api = NewsApiFactory.newsApi
        val news = api.getNews(category = category)
        return news
    }
}
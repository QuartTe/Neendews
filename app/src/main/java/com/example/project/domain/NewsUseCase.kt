package com.example.project.domain

import com.example.project.data.models.NewsResponse
import com.example.project.data.repo.NewsRepo

object NewsUseCase {

    suspend fun getNews(category: String):NewsResponse{
        return NewsRepo.getNews(category)
    }
}
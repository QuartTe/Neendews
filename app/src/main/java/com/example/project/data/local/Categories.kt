package com.example.project.data.local

object Categories {
    private val categories = listOf("technology",
        "general",
        "health",
        "sports",
        "business",
        "science",
        "entertainment",)

    fun getCategories(): List<String>{
        return categories
    }
}
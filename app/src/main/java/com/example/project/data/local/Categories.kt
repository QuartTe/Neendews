package com.example.project.data.local

object Categories {
    private val categories = listOf("technology",
        "world",
        "sports",
        "automobile",
        "business",
        "science",
        "politics",
        "startup",
        "hatke",)

    fun getCategories(): List<String>{
        return categories
    }
}
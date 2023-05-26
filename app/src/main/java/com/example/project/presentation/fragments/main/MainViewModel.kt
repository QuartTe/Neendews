package com.example.project.presentation.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.models.NewsResponse
import com.example.project.domain.NewsUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val newsLiveData = MutableLiveData<NewsResponse?>()



    fun getNews(category: String){

        viewModelScope.launch {
            try {
                val news = NewsUseCase.getNews(category)
                newsLiveData.postValue(news)
            }catch(exception:Exception){
                newsLiveData.postValue(null)
            }
        }

    }

}
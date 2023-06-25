package com.example.project.presentation.fragments.main

import android.util.Log
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
            try{
                val news = NewsUseCase.getNews(category)
                Log.d("News2", news.toString())
                newsLiveData.postValue(news)
            }catch(exception:Exception){
                Log.d("News2", "Exception")
                newsLiveData.postValue(null)
            }
        }

    }

}
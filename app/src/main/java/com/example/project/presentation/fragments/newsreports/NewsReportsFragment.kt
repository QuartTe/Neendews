package com.example.project.presentation.fragments.newsreports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.project.R
import com.example.project.data.models.Data
import com.example.project.data.models.NewsResponse
import com.example.project.databinding.FragmentMainBinding
import com.example.project.databinding.FragmentNewsReportsBinding
import com.example.project.presentation.adapters.NewsAdapter


class NewsReportsFragment : Fragment(R.layout.fragment_news_reports) {
    private lateinit var binding: FragmentNewsReportsBinding

    private val args: NewsReportsFragmentArgs by navArgs()

    private lateinit var adapter: NewsAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewsReportsBinding.bind(view)

        val news = args.news

        val categoryNameText = activity?.findViewById<TextView>(R.id.textCategory)
        categoryNameText?.text = news?.category

        setupRcView(news!!.articles)
    }


    override fun onDestroy() {
        super.onDestroy()
        val categoryNameText = activity?.findViewById<TextView>(R.id.textCategory)
        categoryNameText?.text = "Category"
    }


    private fun setupRcView(news: List<Data>) = with(binding){
        adapter = NewsAdapter(){
            val directions = NewsReportsFragmentDirections.actionNewsReportsFragmentToArticleFragment(it)
            findNavController().navigate(directions)
        }

        recyclerViewNews.adapter = adapter

        adapter.setNews(news)
    }

}
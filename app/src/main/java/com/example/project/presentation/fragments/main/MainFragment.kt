package com.example.project.presentation.fragments.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.data.local.Categories
import com.example.project.data.models.NewsResponse
import com.example.project.databinding.FragmentMainBinding
import com.example.project.presentation.adapters.CategoryAdapter
import com.example.project.presentation.adapters.NewsAdapter


class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    private lateinit var adapter: CategoryAdapter

    private lateinit var categoryViewModel: MainViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        categoryViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        categoryViewModel.newsLiveData.observe(viewLifecycleOwner){news->
            Log.d("News", news.toString())
            if(news!=null) {
                val directions =
                    MainFragmentDirections.actionMainFragmentToNewsReportsFragment(news)
                findNavController().navigate(directions)
                Log.d("Travel", "To the next fragment")
                categoryViewModel.newsLiveData.postValue(null)
            }
        }

        //Log.d("HERE", "Try to setupRcView")

        setupRcView()
    }



    private fun setupRcView() = with(binding){
        categoryView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CategoryAdapter{category->
            categoryViewModel.getNews(category)
        }

        categoryView.addItemDecoration(DividerItemDecoration(requireContext(),RecyclerView.VERTICAL))

        categoryView.adapter = adapter

        //Log.d("HERE", Categories.getCategories()[0])

        adapter.setList(Categories.getCategories())
    }

}
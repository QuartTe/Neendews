package com.example.project.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.data.models.Data
import com.example.project.databinding.NewsItemBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class NewsAdapter(val getData: (data:Data) -> Unit): RecyclerView.Adapter<NewsAdapter.Holder>() {

    private var newsList = ArrayList<Data>()

    inner class Holder(view: View):RecyclerView.ViewHolder(view){
        val binding = NewsItemBinding.bind(view)

        @SuppressLint("NewApi")

        fun bind(news: Data) = with(binding){
            newsTitle.text = news.title
            val ldt = LocalDateTime.parse(news.publishedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
            val format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            newsPublishTime.text = format.format(ldt)

            Glide
                .with(newsImage.context)
                .load(news.urlToImage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(newsImage)

            binding.root.setOnClickListener{
                getData(newsList[adapterPosition])
            }
        }
    }

    fun setNews(category:List<Data>?) {
        this.newsList.clear()
        this.newsList = ArrayList(category)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Holder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount():Int{
        return newsList.size
    }

}
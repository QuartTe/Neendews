package com.example.project.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat.NestedScrollType
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.data.models.Data
import com.example.project.data.models.NewsResponse
import com.example.project.databinding.CategoryItemBinding
import com.example.project.databinding.NewsItemBinding


class NewsAdapter(val getData: (data:Data) -> Unit): RecyclerView.Adapter<NewsAdapter.Holder>() {

    private var newsList = ArrayList<Data>()

    inner class Holder(view: View):RecyclerView.ViewHolder(view){
        val binding = NewsItemBinding.bind(view)

        fun bind(news: Data) = with(binding){
            newsTitle.text = news.title
            newsPublishTime.text = news.date + " " + news.time
            Glide
                .with(newsImage.context)
                .load(news.imageUrl)
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
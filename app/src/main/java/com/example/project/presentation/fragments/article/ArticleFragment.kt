package com.example.project.presentation.fragments.article

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.databinding.FragmentArticleBinding


class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var binding: FragmentArticleBinding

    private val args: ArticleFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentArticleBinding.bind(view)

        val article = args.news

        with(binding){

            textArAuthor.text = article?.author?:"Unknown"
            textArContent.text = article?.content
            textArTitle.text = article?.title
            textUrl.text = "Click here for full article"
            textUrl.setOnClickListener{
                val intentBrowser = Intent(Intent.ACTION_VIEW)
                intentBrowser.setData(Uri.parse(article?.url))
                startActivity(intentBrowser)
            }

            Glide
                .with(imageArticle.context)
                .load(article?.urlToImage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageArticle)
        }
    }

}
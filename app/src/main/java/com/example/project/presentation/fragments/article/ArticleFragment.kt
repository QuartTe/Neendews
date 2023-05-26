package com.example.project.presentation.fragments.article

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
            textArAuthor.text = article?.author
            textArContent.text = article?.content
            textArTitle.text = article?.title
            Glide
                .with(imageArticle.context)
                .load(article?.imageUrl)
                .into(imageArticle)
        }
    }

}
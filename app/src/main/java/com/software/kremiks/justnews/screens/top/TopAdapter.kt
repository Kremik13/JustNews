package com.software.kremiks.justnews.screens.top

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.extensions.inflate
import kotlinx.android.synthetic.main.item_news_feed.view.*

class TopAdapter(
        private val onReadMoreClick: (() -> Unit),
        private val onFavouriteClicked: (() -> Unit),
        private val articles: List<Article> = emptyList()
        ) : RecyclerView.Adapter<TopAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(articles[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_news_feed))

    override fun getItemCount(): Int = articles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.apply {
                articleSourceTV.text = article.source.name
                articleTitleTV.text = article.title
                articleContentTV.apply {
                    text = article.description
                    visibility = View.VISIBLE
                }

                readMoreBtn.setOnClickListener { onReadMoreClick.invoke() }
                favouriteSourceBtn.setOnClickListener { onFavouriteClicked.invoke() }
            }
        }
    }
}
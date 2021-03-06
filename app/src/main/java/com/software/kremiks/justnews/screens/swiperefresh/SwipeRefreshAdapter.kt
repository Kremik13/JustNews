package com.software.kremiks.justnews.screens.swiperefresh

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.data.local.Prefs
import com.software.kremiks.justnews.extensions.inflate
import com.software.kremiks.justnews.extensions.loadImage
import kotlinx.android.synthetic.main.item_news_feed.view.*

class SwipeRefreshAdapter(
        private val prefs: Prefs,
        private val onReadMoreClick: ((String) -> Unit),
        private val onFavoriteClick: ((String?) -> Unit),
        var articles: List<Article> = emptyList()
) : RecyclerView.Adapter<SwipeRefreshAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(articles[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_news_feed))

    override fun getItemCount(): Int = articles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            itemView.apply {
                articleSourceTV.text = article.source.name
                articleHeaderIV.loadImage(context, article.imageUrl)
                articleTitleTV.text = article.title
                articleContentTV.apply {
                    text = article.description
                    visibility = View.VISIBLE
                }
                article.source.id?.let {
                    if (prefs.favorites.contains(it)) {
                        favouriteSourceBtn.setImageResource(R.drawable.ic_favorite)
                    } else {
                        favouriteSourceBtn.setImageResource(R.drawable.ic_favorite_border)
                    }
                }
                readMoreBtn.setOnClickListener { onReadMoreClick.invoke(article.url) }
                favouriteSourceBtn.setOnClickListener { onFavoriteClick.invoke(article.source.id) }
            }
        }
    }
}
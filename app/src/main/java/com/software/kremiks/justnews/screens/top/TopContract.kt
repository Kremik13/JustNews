package com.software.kremiks.justnews.screens.top

import android.support.annotation.StringRes
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.screens.BaseContract

interface TopContract {

    interface View : BaseContract.View<TopContract.Presenter> {

        fun setArticles(news: List<Article>)

        fun showNoArticles()

        fun showToast(@StringRes messageId: Int)

        fun showShowRefreshing(isShown: Boolean)

        fun editFavorites(sourceName: String)
    }

    interface Presenter : BaseContract.Presenter {

        fun onRefresh()

        fun onReadMoreClick(url: String)

        fun onFavoriteClick(sourceName: String)

        fun loadArticleImage(imageUrl: String?)
    }
}
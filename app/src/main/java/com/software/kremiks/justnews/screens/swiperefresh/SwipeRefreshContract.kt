package com.software.kremiks.justnews.screens.swiperefresh

import android.support.annotation.StringRes
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.screens.BaseContract

interface SwipeRefreshContract {

    interface View<out T : Presenter> : BaseContract.View<T> {

        fun setArticles(news: List<Article>)

        fun showNoArticles()

        fun showToast(@StringRes messageId: Int)

        fun showShowRefreshing(isShown: Boolean)

        fun editFavorites(sourceName: String)

        fun openBrowser(url: String)
    }

    interface Presenter : BaseContract.Presenter {

        fun onRefresh()

        fun onReadMoreClick(url: String)

        fun onFavoriteClick(sourceId: String?)
    }
}
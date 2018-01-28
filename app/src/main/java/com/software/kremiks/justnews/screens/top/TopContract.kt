package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.screens.BaseContract

interface TopContract {

    interface View : BaseContract.View<TopContract.Presenter> {

        fun setArticles(news: List<Article>)
    }

    interface Presenter : BaseContract.Presenter {

        fun onRefresh()

        fun onReadMoreClick()

        fun onFavouriteClicked()

        fun loadArticleImage(imageUrl: String?)
    }
}
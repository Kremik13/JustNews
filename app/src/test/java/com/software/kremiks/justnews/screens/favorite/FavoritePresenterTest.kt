package com.software.kremiks.justnews.screens.favorite

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.software.kremiks.justnews.ImmediateSchedulerExtension
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.data.ArticlesResponse
import com.software.kremiks.justnews.data.remote.NewsApi
import io.reactivex.Single
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ImmediateSchedulerExtension::class)
internal class FavoritePresenterTest {

    private val model: NewsApi = mock()
    private val view: FavoriteContract.View = mock()
    private val favorites = setOf("One", "Two", "Three")
    private val article: Article = mock()
    private val articles = ArticlesResponse(listOf(article, article, article))
    private val presenter by lazy {
        FavoritePresenter(view, model)
    }

    @Test
    fun onRefresh() {
        whenever(view.getFavorites()).thenReturn(favorites)
        whenever(model.getFavoriteNews(favorites.toList())).thenReturn(Single.just(articles))

        presenter.onRefresh()

        verify(view).setArticles(articles.articles)
    }
}
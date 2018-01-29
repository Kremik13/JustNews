package com.software.kremiks.justnews.screens.swiperefresh

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.software.kremiks.justnews.ImmediateSchedulerExtension
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.data.ArticlesResponse
import com.software.kremiks.justnews.data.remote.NewsApi
import com.software.kremiks.justnews.screens.top.TopContract
import com.software.kremiks.justnews.screens.top.TopPresenter
import io.reactivex.Single
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ImmediateSchedulerExtension::class)
internal class SwipeRefreshPresenterTest {

    private val model: NewsApi = mock()
    private val view: TopContract.View = mock()
    private val text = "text"
    private val article: Article = mock()
    private val internetError = R.string.internal_server_error
    private val articlesResponse: ArticlesResponse = ArticlesResponse(listOf(article, article, article))
    private val noArticles = ArticlesResponse(emptyList())

//    TODO("Find a way to mock presenter with real functions and params)
    private val presenter by lazy {
        TopPresenter(view, model)
    }

    @BeforeEach
    fun setUp() {
        presenter.onCreate()
    }

    @AfterEach
    fun tearDown() {
        presenter.onDestroy()
    }

    @Test
    @DisplayName("Given Single with articles" +
            " When onRefresh called" +
            " Then call view.setArticles")
    fun onRefreshSuccessArticlesList() {
        whenever(model.getTopNews()).thenReturn(Single.just(articlesResponse))

        presenter.onRefresh()

        verify(view).setArticles(articlesResponse.articles)
    }

    @Test
    @DisplayName("Given Single with empty list" +
            " When onRefresh called" +
            " Then call view.showNoArticles")
    fun onRefreshSuccessEmptyList() {
        whenever(model.getTopNews()).thenReturn(Single.just(noArticles))

        presenter.onRefresh()

        verify(view).showNoArticles()
    }

    @Test
    @DisplayName("Given Single with Throwable" +
            " When onRefresh called" +
            " Then call view.showToast")
    fun onRefreshErrorHttpError() {
        whenever(model.getTopNews()).thenReturn(Single.error(Throwable()))

        presenter.onRefresh()

        verify(view).showToast(internetError)
    }

    @Test
    @DisplayName("Given image url /text/" +
            " When onFavoriteClick called" +
            " Then call view.editFavorites")
    fun onFavoriteClick() {

        presenter.onFavoriteClick(text)

        verify(view).editFavorites(text)
    }

    @Test
    @DisplayName("Given article url /text/" +
            " When onReadMoreClick called" +
            " Then call view.openBrowser")
    fun onReadMoreClick() {

        presenter.onReadMoreClick(text)

        verify(view).openBrowser(text)
    }
}
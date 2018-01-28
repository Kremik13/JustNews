package com.software.kremiks.justnews.screens.top

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.software.kremiks.justnews.data.remote.NewsApi
import org.junit.jupiter.api.AfterEach

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class TopPresenterTest {

    private val model: NewsApi = mock()

    private val presenter by lazy {
        TopPresenter(model)
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
    @DisplayName("")
    fun onRefresh() {
        whenever(model)
    }
}
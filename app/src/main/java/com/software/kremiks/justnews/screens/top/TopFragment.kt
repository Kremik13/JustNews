package com.software.kremiks.justnews.screens.top

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.screens.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class TopFragment : BaseFragment<TopContract.Presenter>(), TopContract.View {

    @Inject
    override lateinit var presenter: TopContract.Presenter
    override val contentViewId = R.layout.fragment_feed
    private val adapter: TopAdapter by lazy {
        TopAdapter(presenter::onReadMoreClick, presenter::onFavouriteClicked )
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        feedSRL.setOnRefreshListener(presenter::onRefresh)
        feedRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TopFragment.adapter
            this.adapter = adapter
        }
        presenter.onCreate()
    }

    override fun showShowRefreshing(isShown: Boolean) {
        feedSRL.isRefreshing = isShown
    }

    override fun showNoArticles() {
        feedRV.visibility = View.GONE
        noArticlesLL.visibility = View.VISIBLE
    }

    override fun showToast(messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
    }

    override fun setArticles(news: List<Article>) {
        adapter.articles = news
        adapter.notifyDataSetChanged()
    }
}
package com.software.kremiks.justnews.screens.top

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.data.local.Prefs
import com.software.kremiks.justnews.screens.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class TopFragment : BaseFragment<TopContract.Presenter>(), TopContract.View {

    @Inject
    override lateinit var presenter: TopContract.Presenter
    @Inject
    lateinit var prefs: Prefs
    override val contentViewId = R.layout.fragment_feed
    private val adapter: TopAdapter by lazy {
        TopAdapter(prefs, presenter::onReadMoreClick, presenter::onFavoriteClick)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        AndroidSupportInjection.inject(this)
        feedSRL.setOnRefreshListener(presenter::onRefresh)
        feedRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TopFragment.adapter
            this.adapter = adapter
        }
    }

    override fun onStop() {
        feedSRL.isRefreshing = false
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                presenter.onRefresh()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showShowRefreshing(isShown: Boolean) {
        feedSRL.isRefreshing = isShown
    }

    override fun setArticles(news: List<Article>) {
        adapter.articles = news
        adapter.notifyDataSetChanged()
    }

    override fun showNoArticles() {
        feedRV.visibility = View.GONE
        noArticlesLL.visibility = View.VISIBLE
    }

    override fun showToast(messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
    }

    override fun editFavorites(sourceName: String) {
        if (prefs.favorites.contains(sourceName)) {
            prefs.favorites = prefs.favorites.minus(sourceName)
        } else {
            prefs.favorites = prefs.favorites.plus(sourceName)
        }
        adapter.notifyDataSetChanged()
    }

    override fun openBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}
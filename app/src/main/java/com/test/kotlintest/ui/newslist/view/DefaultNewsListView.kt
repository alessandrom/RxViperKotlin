package com.test.kotlintest.ui.newslist.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout

import com.test.kotlintest.R
import com.test.kotlintest.model.Article
import io.reactivex.Observable
import kotlinx.android.synthetic.main.news_list_view.view.*
import android.support.v7.widget.DividerItemDecoration

class DefaultNewsListView(context: Context) : LinearLayout(context), NewsListView {

    init {
        inflate(context, R.layout.news_list_view, this)
    }

    private lateinit var adapter: ArticlesAdapter

    override fun showNewsList(articles: List<Article>) {
        articlesRecyclerView.layoutManager = LinearLayoutManager(context)
        articlesRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = ArticlesAdapter(context, articles)
        articlesRecyclerView.adapter = adapter
    }

    override fun getNewsListObserver(): Observable<Article> {
        return adapter.clickEvent
    }

    override fun showError() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(): View {
        return this
    }
}

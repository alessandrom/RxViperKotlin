package com.test.kotlintest.ui.articledetail.view


import android.content.Context
import android.view.View
import android.widget.LinearLayout

import com.test.kotlintest.R
import kotlinx.android.synthetic.main.article_detail_view.view.*

class DefaultArticleDetailView(context: Context) : LinearLayout(context), ArticleDetailView {

    init {
        inflate(context, R.layout.article_detail_view, this)
    }

    override fun loadArticle(url: String) {
        articleWebView.loadUrl(url)
    }

    override fun getView(): View {
        return this
    }

}

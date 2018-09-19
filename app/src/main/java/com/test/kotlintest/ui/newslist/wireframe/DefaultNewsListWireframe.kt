package com.test.kotlintest.ui.newslist.wireframe

import android.content.Context
import android.content.Intent
import com.test.kotlintest.model.Article
import com.test.kotlintest.network.CategoriesConstants
import com.test.kotlintest.ui.articledetail.ArticleDetailActivity
import com.test.kotlintest.ui.articledetail.interactor.DefaultArticleDetailInteractor

class DefaultNewsListWireframe(private val context: Context) : NewsListWireframe {

    override fun goToArticleDetail(article: Article) {
        val intent = Intent(context, ArticleDetailActivity::class.java)
        intent.putExtra(DefaultArticleDetailInteractor.ARTICLE_DETAIL_EXTRA_CODE, article)
        context.startActivity(intent)
    }
}
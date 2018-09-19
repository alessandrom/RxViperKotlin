package com.test.kotlintest.ui.articledetail.interactor

import android.app.Activity
import com.test.kotlintest.model.Article

class DefaultArticleDetailInteractor(private val activity: Activity) : ArticleDetailInteractor {

    private var article: Article

    init {
        article = activity.intent.getSerializableExtra(ARTICLE_DETAIL_EXTRA_CODE) as Article
    }

    companion object {
        const val ARTICLE_DETAIL_EXTRA_CODE: String = "articleDetailExtraCode"
    }

    override fun getArticleDetailUrl(): String {
        return article.url
    }
}
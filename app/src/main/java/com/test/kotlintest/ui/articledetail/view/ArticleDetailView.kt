package com.test.kotlintest.ui.articledetail.view

import android.view.View

interface ArticleDetailView {

    fun loadArticle(url: String)
    fun getView(): View
}

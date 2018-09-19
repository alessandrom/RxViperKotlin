package com.test.kotlintest.ui.newslist.wireframe

import com.test.kotlintest.model.Article

interface NewsListWireframe {
    fun goToArticleDetail(article: Article)
}
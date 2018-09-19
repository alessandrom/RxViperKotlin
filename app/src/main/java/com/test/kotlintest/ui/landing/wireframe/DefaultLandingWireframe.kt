package com.test.kotlintest.ui.landing.wireframe

import android.content.Context
import android.content.Intent
import com.test.kotlintest.ui.newslist.NewsListActivity
import com.test.kotlintest.ui.newslist.interactor.DefaultNewsListInteractor

class DefaultLandingWireframe(private val context: Context) : LandingWireframe {

    override fun goToArticlesList(category: String) {
        val intent = Intent(context, NewsListActivity::class.java)
        intent.putExtra(DefaultNewsListInteractor.CATEGORY_EXTRA_CODE, category)
        context.startActivity(intent)
    }

}

package com.test.kotlintest.ui.articledetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.kotlintest.ui.articledetail.presenter.ArticleDetailPresenter
import com.test.kotlintest.ui.articledetail.view.ArticleDetailView
import dagger.android.AndroidInjection
import javax.inject.Inject

class ArticleDetailActivity : AppCompatActivity() {

    @Inject lateinit var view: ArticleDetailView
    @Inject lateinit var presenter: ArticleDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this);
        setContentView(view.getView())

        presenter.showDetail()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}

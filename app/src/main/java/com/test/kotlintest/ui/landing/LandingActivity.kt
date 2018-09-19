package com.test.kotlintest.ui.landing

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.kotlintest.ui.landing.presenter.LandingPresenter
import com.test.kotlintest.ui.landing.view.LandingView
import dagger.android.AndroidInjection
import javax.inject.Inject

class LandingActivity : AppCompatActivity() {

    @Inject internal lateinit var view: LandingView
    @Inject internal lateinit var presenter: LandingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this);
        setContentView(view.getView())

        presenter.loadArticles()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}

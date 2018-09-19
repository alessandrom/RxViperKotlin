package com.test.kotlintest

import android.app.Application
import android.content.Context
import com.test.kotlintest.ui.articledetail.core.ArticleDetailInjectors
import com.test.kotlintest.ui.landing.core.LandingInjectors
import com.test.kotlintest.ui.newslist.core.NewsListInjectors
import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AppModule::class, LandingInjectors::class, NewsListInjectors::class, ArticleDetailInjectors::class])
interface AppComponent : AndroidInjector<NewsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}

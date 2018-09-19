package com.test.kotlintest.ui.articledetail.core

import com.test.kotlintest.ui.articledetail.ArticleDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleDetailInjectors {
    @ArticleDetailScope
    @ContributesAndroidInjector(modules = [ArticleDetailModule::class])
    internal abstract fun contributeArticleDetailActivity(): ArticleDetailActivity
}

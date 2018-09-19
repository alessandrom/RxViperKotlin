package com.test.kotlintest.ui.newslist.core

import com.test.kotlintest.ui.newslist.NewsListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsListInjectors {
    @NewsListScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    internal abstract fun contributeNewsListActivity(): NewsListActivity
}

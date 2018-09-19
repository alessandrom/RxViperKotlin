package com.test.kotlintest

import com.test.kotlintest.network.NetworkModule

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class, NetworkModule::class])
class AppModule {

}

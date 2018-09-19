package com.test.kotlintest.ui.landing.wireframe

import android.content.Context
import android.content.Intent
import com.test.kotlintest.network.CategoriesConstants
import com.test.kotlintest.ui.newslist.interactor.DefaultNewsListInteractor
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DefaultLandingWireframeTest {


    lateinit var context: Context

    lateinit var wireframe: DefaultLandingWireframe

    @Before
    fun setUp() {
        context = mock(Context::class.java)
        wireframe = DefaultLandingWireframe(context)
    }


    @Test
    fun testGoToArticlesList_shouldOpenCorrectArticleList() {

        doNothing().`when`(context).startActivity(any(Intent::class.java))
        wireframe.goToArticlesList(CategoriesConstants.GENERAL_CATEGORY_PARAM)


        val captor: ArgumentCaptor<Intent> = ArgumentCaptor.forClass(Intent::class.java)
        verify(context).startActivity(captor.capture())
        val category : String = captor.value.extras.getString(DefaultNewsListInteractor.CATEGORY_EXTRA_CODE)
        assertEquals(category, "general")
    }
}
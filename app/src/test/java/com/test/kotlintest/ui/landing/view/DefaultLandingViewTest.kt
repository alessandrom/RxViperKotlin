package com.test.kotlintest.ui.landing.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.test.kotlintest.R
import kotlinx.android.synthetic.main.landing_view.view.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DefaultLandingViewTest {

    lateinit var landingView : DefaultLandingView
    @Mock lateinit var layoutInflater: LayoutInflater
    @Mock lateinit var container: ViewGroup
    @Mock lateinit var view: View


    @Mock lateinit var mockContext: Context
    @Mock lateinit var mockButton: ImageButton

    @Before
    fun setUp() {
        landingView = DefaultLandingView(mockContext)
    }


    @Test
    fun test() {
//        `when`(landingView.findViewById<ImageButton>(anyInt())).thenReturn(mockButton)
//        `when`(landingView.technologyButton).thenReturn(mockButton)

        doReturn(view).`when`(landingView)
        doReturn(mockButton).`when`(view).findViewById<ImageButton>(R.id.technologyButton)

//        landingView.inflate(null,null,false)
//        Mockito.`when`(landingView.technologyButton).thenReturn(mockButton)
    }
}

package com.test.kotlintest.model

import java.io.Serializable

class HeadlinesResponse : Serializable {

    lateinit var articles: List<Article>
}

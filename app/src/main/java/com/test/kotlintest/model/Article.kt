package com.test.kotlintest.model

import java.io.Serializable

class Article : Serializable {

    var title: String? = null
    var description: String? = null
    lateinit var url: String
    var urlToImage: String? = null
}

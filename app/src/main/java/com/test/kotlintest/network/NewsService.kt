package com.test.kotlintest.network

import com.test.kotlintest.model.HeadlinesResponse


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    //    https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=53c4a8a570f849e38a4b278320999ecc
    @GET("top-headlines")
    fun getHeadlines(@Query("country") country: String, @Query("category") category: String, @Query("apiKey") apiKey: String): Observable<HeadlinesResponse>

}

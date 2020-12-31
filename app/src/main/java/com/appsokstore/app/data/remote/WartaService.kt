package com.appsokstore.app.data.remote

import com.appsokstore.app.data.model.WartaList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WartaService {
    @GET("/")
    fun listWarta(): Call<WartaList>

    @GET("detail/")
    fun detailWarta(@Query("url") url: String): Call<WartaList>

    @GET("search/")
    fun searchWarta(@Query("q") query: String): Call<WartaList>
}
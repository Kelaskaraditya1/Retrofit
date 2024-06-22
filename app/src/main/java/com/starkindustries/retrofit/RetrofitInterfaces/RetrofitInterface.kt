package com.starkindustries.retrofit.RetrofitInterfaces

import com.starkindustries.retrofit.Data.QuotesList
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface
{
    @GET("/quotes")
    suspend fun getQuotes():retrofit2.Response<QuotesList>
}
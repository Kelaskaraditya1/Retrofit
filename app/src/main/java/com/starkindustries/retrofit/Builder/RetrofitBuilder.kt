package com.starkindustries.retrofit.Builder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object
RetrofitBuilder
{
    val URL="https://quotable.io/"
    fun getInstance():Retrofit
    {
        return Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}
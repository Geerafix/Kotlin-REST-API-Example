package com.nonogramnest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitClient {
    private const val URL = "http://192.168.0.236:3000/"

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

}
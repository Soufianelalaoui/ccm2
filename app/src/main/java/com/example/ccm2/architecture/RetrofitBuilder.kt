package com.example.ccm2.architecture

import com.example.ccm2.chuckNorris.remote.ChuckNorrisQuoteEndpoint
import com.example.ccm2.tp4.remote.Tp4QuoteEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    private val tp4retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://random-data-api.com/api/address/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()




    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint = retrofit.create(ChuckNorrisQuoteEndpoint::class.java)

    fun getTp4Quote(): Tp4QuoteEndpoint = tp4retrofit.create(Tp4QuoteEndpoint::class.java)
}

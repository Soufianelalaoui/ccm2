package com.example.ccm2.tp4.remote

import com.example.ccm2.tp4.model.Tp4Retrofit
import retrofit2.http.GET

interface Tp4QuoteEndpoint {
    @GET("random_address")
    suspend fun getRandomQuote() : Tp4Retrofit

}
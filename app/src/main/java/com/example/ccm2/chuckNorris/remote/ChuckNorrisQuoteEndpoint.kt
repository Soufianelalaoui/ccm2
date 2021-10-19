package com.example.ccm2.chuckNorris.remote

import com.example.ccm2.chuckNorris.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {
    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisRetrofit

}
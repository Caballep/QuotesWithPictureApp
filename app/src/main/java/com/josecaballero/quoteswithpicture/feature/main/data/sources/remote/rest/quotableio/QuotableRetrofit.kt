package com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.quotableio

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuotableRetrofitProvider {
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.quotable.io/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}

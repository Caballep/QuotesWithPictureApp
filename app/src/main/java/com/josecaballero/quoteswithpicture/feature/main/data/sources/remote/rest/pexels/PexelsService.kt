package com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.dto.PhotoDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PexelsService {
    @Headers("Authorization: a4fntd9nOTPGPWlxODAUH97YZQ0aFaDp6gWFfFijT1gQZSAXACbEj7eQ")
    @GET("v1/search")
    suspend fun getPhotos(
        @Query("query") keyword: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 1
    ): PhotoDTO
}
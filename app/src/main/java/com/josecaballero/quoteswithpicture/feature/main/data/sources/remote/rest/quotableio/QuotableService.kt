package com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.dto.QuoteDTO
import retrofit2.http.GET

interface QuotableService {
    @GET("random")
    suspend fun getRandomQuote(): QuoteDTO
}

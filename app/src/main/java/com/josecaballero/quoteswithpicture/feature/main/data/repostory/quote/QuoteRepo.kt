package com.josecaballero.quoteswithpicture.feature.main.data.repostory.quote

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.QuotableService
import javax.inject.Inject

class QuoteRepo @Inject constructor(private val quoteService: QuotableService) {

    suspend fun getRemoteRandomQuote(): QuoteData {
        val quoteDTO = quoteService.getRandomQuote()
        return QuoteData.from(quoteDTO)
    }
}

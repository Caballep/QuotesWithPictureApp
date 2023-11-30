package com.josecaballero.quoteswithpicture.feature.main.data.repostory.quote

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.dto.QuoteDTO

data class QuoteData(
    val content: String,
    val author: String,
    val tag: String
) {
    companion object {
        fun from(quoteDTO: QuoteDTO): QuoteData {
            return QuoteData(
                content = quoteDTO.content,
                author = quoteDTO.author,
                tag = quoteDTO.tags.first()
            )
        }
    }
}

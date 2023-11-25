package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.viewdata

import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel

data class ImageQuoteViewData(
    val quote: String,
    val author: String,
    val imageUrl: String
) {
    companion object {
        fun from(model: ImageQuoteModel) = ImageQuoteViewData (
            quote = model.quote,
            author = model.author,
            imageUrl = model.imageUrl
        )
    }
}

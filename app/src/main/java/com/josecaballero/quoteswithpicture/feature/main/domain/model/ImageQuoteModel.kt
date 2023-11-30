package com.josecaballero.quoteswithpicture.feature.main.domain.model

import com.josecaballero.quoteswithpicture.feature.main.data.repostory.image.ImageData
import com.josecaballero.quoteswithpicture.feature.main.data.repostory.quote.QuoteData
import com.josecaballero.quoteswithpicture.feature.main.domain.helper.ImageHelper
import com.josecaballero.quoteswithpicture.feature.main.domain.model.enumerable.ImageQuoteColor

data class ImageQuoteModel(
    val quoteContent: String,
    val quoteAuthor: String,
    val imageUrl: String,
    val imageOppositeColors: ImageOppositeColors,
    val imagePhotographer: String
) {
    data class ImageOppositeColors(
        val blackOrWhiteColor: ImageQuoteColor,
        val color: ImageQuoteColor,
    )

    companion object {
        fun from(
            quoteData: QuoteData,
            imageData: ImageData?,
            imageHelper: ImageHelper = ImageHelper()
        ) = ImageQuoteModel(
            quoteContent = quoteData.content,
            quoteAuthor = quoteData.author,
            imageUrl = imageData?.imageUrl ?: imageHelper.getDefaultImageUrl(),
            imageOppositeColors = ImageOppositeColors(
                blackOrWhiteColor = imageHelper.getContrastingBlackOrWhite(imageData?.averageColorHex),
                color = imageHelper.getContrastingColor(imageData?.averageColorHex)
            ),
            imagePhotographer = imageData?.photographer ?: imageHelper.getDefaultImagePhotographer()
        )
    }
}

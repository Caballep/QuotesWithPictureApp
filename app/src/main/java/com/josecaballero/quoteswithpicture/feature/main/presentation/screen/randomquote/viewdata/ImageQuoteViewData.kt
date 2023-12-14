package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.viewdata

import androidx.compose.ui.graphics.Color
import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import com.josecaballero.quoteswithpicture.feature.main.domain.model.enumerable.ImageQuoteColor
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.ColorShades

data class ImageQuoteViewData(
    val textColorA: Color,
    val textColorB: Color,
    val quoteContent: String,
    val quoteAuthor: String,
    val imageUrl: String,
    val imagePhotographer: String
) {
    companion object {
        fun from(model: ImageQuoteModel): ImageQuoteViewData {
            return ImageQuoteViewData(
                textColorA = mapImageQuoteColorToColorShades(model.imageOppositeColors.color),
                textColorB = mapImageQuoteColorToColorShades(model.imageOppositeColors.blackOrWhiteColor),
                quoteContent = model.quoteContent,
                quoteAuthor = model.quoteAuthor,
                imageUrl = model.imageUrl,
                imagePhotographer = model.imagePhotographer
            )
        }

        private fun mapImageQuoteColorToColorShades(imageQuoteColor: ImageQuoteColor): Color {
            return when (imageQuoteColor) {
                ImageQuoteColor.WHITE -> ColorShades.WHITE.color
                ImageQuoteColor.BLACK -> ColorShades.BLACK.color
                ImageQuoteColor.CYAN_LIGHT -> ColorShades.LIGHT_CYAN.color
                ImageQuoteColor.CYAN_DARK -> ColorShades.DARK_CYAN.color
                ImageQuoteColor.MAGENTA_LIGHT -> ColorShades.LIGHT_MAGENTA.color
                ImageQuoteColor.MAGENTA_DARK -> ColorShades.DARK_MAGENTA.color
                ImageQuoteColor.YELLOW_LIGHT -> ColorShades.LIGHT_YELLOW.color
                ImageQuoteColor.YELLOW_DARK -> ColorShades.DARK_YELLOW.color
            }
        }
    }
}

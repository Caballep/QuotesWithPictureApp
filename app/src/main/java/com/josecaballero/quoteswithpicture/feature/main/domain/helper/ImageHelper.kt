package com.josecaballero.quoteswithpicture.feature.main.domain.helper

import com.josecaballero.quoteswithpicture.feature.main.domain.model.enumerable.ImageQuoteColor

class ImageHelper {

    private val defaultBlackOrWhite = ImageQuoteColor.WHITE
    private val defaultColor = ImageQuoteColor.YELLOW_DARK
    private val defaultImageUrl = "https://www.newegg.com/insider/wp-content/uploads/2014/04/windows_xp_bliss-wide.jpg"
    private val defaultImagePhotographer = "Charles O'Rear"

    private fun hexToRgb(hexColor: String): Triple<Int, Int, Int> {
        val cleanHex = hexColor.replace("#", "")
        val red = Integer.valueOf(cleanHex.substring(0, 2), 16)
        val green = Integer.valueOf(cleanHex.substring(2, 4), 16)
        val blue = Integer.valueOf(cleanHex.substring(4, 6), 16)
        return Triple(red, green, blue)
    }

    fun getContrastingBlackOrWhite(hexColor: String?): ImageQuoteColor {
        if (hexColor == null) {
            return defaultBlackOrWhite
        }
        val rgb = hexToRgb(hexColor)
        val brightness = (rgb.first + rgb.second + rgb.third) / 3
        return if (brightness < 128) {
            ImageQuoteColor.WHITE
        } else {
            ImageQuoteColor.BLACK
        }
    }

    fun getContrastingColor(hexColor: String?): ImageQuoteColor {
        if (hexColor == null) {
            return defaultColor
        }
        val rgb = hexToRgb(hexColor)
        val oppositeBlackOrWhiteDominance = getContrastingBlackOrWhite(hexColor)
        return when (maxOf(rgb.first, rgb.second, rgb.third)) {
            rgb.first -> {
                // Red is the dominant color
                if (oppositeBlackOrWhiteDominance == ImageQuoteColor.BLACK) {
                    ImageQuoteColor.CYAN_LIGHT
                }
                ImageQuoteColor.CYAN_DARK
            }

            rgb.second -> {
                // Green is the dominant color
                if (oppositeBlackOrWhiteDominance == ImageQuoteColor.BLACK) {
                    ImageQuoteColor.MAGENTA_LIGHT
                }
                ImageQuoteColor.MAGENTA_DARK
            }

            else -> {
                // Blue is the dominant color
                if (oppositeBlackOrWhiteDominance == ImageQuoteColor.BLACK) {
                    ImageQuoteColor.YELLOW_LIGHT
                }
                ImageQuoteColor.YELLOW_DARK
            }
        }
    }

    fun getDefaultImageUrl() = defaultImageUrl
    fun getDefaultImagePhotographer() = defaultImagePhotographer
}
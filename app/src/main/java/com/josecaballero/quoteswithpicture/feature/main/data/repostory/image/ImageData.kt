package com.josecaballero.quoteswithpicture.feature.main.data.repostory.image

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.dto.PhotoDTO

data class ImageData(
    val imageUrl: String?, val averageColorHex: String, val photographer: String
) {
    companion object {
        fun from(photoDTO: PhotoDTO): ImageData? = photoDTO.photos.firstOrNull()?.run {
            ImageData(
                imageUrl = src.large, averageColorHex = averageColor, photographer = photographer
            )
        }
    }
}

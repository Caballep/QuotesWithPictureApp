package com.josecaballero.quoteswithpicture.feature.main.data.repostory.image

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.PexelsService
import javax.inject.Inject

class ImageRepo @Inject constructor(private val pexelsService: PexelsService) {

    suspend fun getRemoteRandomQuote(keyword: String): ImageData? {
        val pexelsDTO = pexelsService.getPhotos(keyword = keyword)
        return ImageData.from(pexelsDTO)
    }
}

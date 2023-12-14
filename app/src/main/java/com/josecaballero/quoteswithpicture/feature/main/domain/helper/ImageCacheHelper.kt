package com.josecaballero.quoteswithpicture.feature.main.domain.helper

import coil.ImageLoader
import coil.request.ImageRequest
import javax.inject.Inject

class ImageCacheHelper @Inject constructor(
    private val imageLoader: ImageLoader,
    private val imageRequestBuilder: ImageRequest.Builder
) {
    fun preloadImageIntoCache(imageUrl: String) {
        val request = imageRequestBuilder.data(imageUrl)
            .build()
        imageLoader.enqueue(request)
    }
}

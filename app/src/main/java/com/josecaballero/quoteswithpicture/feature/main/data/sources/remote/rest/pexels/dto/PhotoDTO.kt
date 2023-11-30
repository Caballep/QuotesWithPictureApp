package com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.dto

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val photos: List<Photo>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("next_page")
    val nextPage: String?
) {
    data class Photo(
        val id: Int,
        val width: Int,
        val height: Int,
        val url: String,
        val photographer: String,
        @SerializedName("photographer_url")
        val photographerUrl: String,
        @SerializedName("photographer_id")
        val photographerId: Int,
        @SerializedName("avg_color")
        val averageColor: String,
        val src: PhotoSource,
        val liked: Boolean,
        val alt: String
    ) {
        data class PhotoSource(
            val original: String,
            @SerializedName("large2x")
            val large2x: String,
            val large: String,
            val medium: String,
            val small: String,
            val portrait: String,
            val landscape: String,
            val tiny: String
        )
    }
}

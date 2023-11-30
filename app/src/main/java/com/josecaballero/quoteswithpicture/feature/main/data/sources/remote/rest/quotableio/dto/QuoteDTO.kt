package com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.dto

import com.google.gson.annotations.SerializedName

data class QuoteDTO(
    @SerializedName("_id")
    val id: String,
    val author: String,
    val content: String,
    val tags: List<String>,
    val authorSlug: String,
    val length: Int,
    val dateAdded: String,
    val dateModified: String
)

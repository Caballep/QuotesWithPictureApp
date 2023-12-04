package com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import java.util.Date

@Entity
data class ImageQuoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val quoteContent: String,
    val quoteAuthor: String,
    val imageUrl: String,
    val blackOrWhiteColor: String,
    val color: String,
    val imagePhotographer: String,
    val dateTime: Date = Date()
) {
    companion object {
        fun from(imageQuoteModel: ImageQuoteModel): ImageQuoteEntity = ImageQuoteEntity(
            quoteContent = imageQuoteModel.quoteContent,
            quoteAuthor = imageQuoteModel.quoteAuthor,
            imageUrl = imageQuoteModel.imageUrl,
            blackOrWhiteColor = imageQuoteModel.imageOppositeColors.blackOrWhiteColor.colorText,
            color = imageQuoteModel.imageOppositeColors.color.colorText,
            imagePhotographer = imageQuoteModel.imagePhotographer
        )
    }
}

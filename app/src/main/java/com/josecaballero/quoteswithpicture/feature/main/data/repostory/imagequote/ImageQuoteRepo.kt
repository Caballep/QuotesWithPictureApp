package com.josecaballero.quoteswithpicture.feature.main.data.repostory.imagequote

import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteDao
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteEntity
import javax.inject.Inject

class ImageQuoteRepo @Inject constructor(private val imageQuoteDao: ImageQuoteDao) {

    suspend fun getAllImageQuotes(): List<ImageQuoteEntity> {
        return imageQuoteDao.getAllImageQuotes()
    }

    suspend fun insertImageQuote(imageQuoteEntity: ImageQuoteEntity) {
        imageQuoteDao.insertImageQuote(imageQuoteEntity)
    }

    suspend fun deleteImageQuote(imageQuoteEntity: ImageQuoteEntity) {
        imageQuoteDao.deleteImageQuote(imageQuoteEntity)
    }
}

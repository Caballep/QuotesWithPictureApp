package com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ImageQuoteDao {

    @Query("SELECT * FROM ImageQuoteEntity")
    suspend fun getAllImageQuotes(): List<ImageQuoteEntity>

    @Insert
    suspend fun insertImageQuote(imageQuoteEntity: ImageQuoteEntity)

    @Delete
    suspend fun deleteImageQuote(imageQuoteEntity: ImageQuoteEntity)
}

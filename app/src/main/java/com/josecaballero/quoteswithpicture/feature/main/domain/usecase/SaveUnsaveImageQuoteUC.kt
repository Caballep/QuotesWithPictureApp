package com.josecaballero.quoteswithpicture.feature.main.domain.usecase

import com.josecaballero.quoteswithpicture.feature.main.data.repostory.imagequote.ImageQuoteRepo
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteEntity
import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import javax.inject.Inject

class SaveUnsaveImageQuoteUC @Inject constructor(private val imageQuoteRepo: ImageQuoteRepo) {

    private var isImageQuoteSaved: Boolean = false
    private var currentImageQuoteModel: ImageQuoteModel? = null
    suspend operator fun invoke(imageQuoteModel: ImageQuoteModel): Boolean {
        if (currentImageQuoteModel != imageQuoteModel) {
            isImageQuoteSaved = false
            currentImageQuoteModel = imageQuoteModel
        }
        if (isImageQuoteSaved) {
            imageQuoteRepo.deleteImageQuote(
                ImageQuoteEntity.from(imageQuoteModel)
            )
            isImageQuoteSaved = false
            return false
        }
        imageQuoteRepo.insertImageQuote(
            ImageQuoteEntity.from(imageQuoteModel)
        )
        isImageQuoteSaved = true
        return true
    }
}

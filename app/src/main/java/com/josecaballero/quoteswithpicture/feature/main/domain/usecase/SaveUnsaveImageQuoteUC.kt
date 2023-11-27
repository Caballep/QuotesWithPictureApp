package com.josecaballero.quoteswithpicture.feature.main.domain.usecase

import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class SaveUnsaveImageQuoteUC @Inject constructor() {

    private lateinit var isImageQuoteModelSaved: Node
    suspend operator fun invoke(imageQuoteModel: ImageQuoteModel): Boolean {
        delay(50)
        if (!::isImageQuoteModelSaved.isInitialized) {
            isImageQuoteModelSaved = Node(imageQuoteModel, true)
        }
        else if (isImageQuoteModelSaved.key != imageQuoteModel) {
            isImageQuoteModelSaved = Node(imageQuoteModel, true)
        }
        else if (isImageQuoteModelSaved.key == imageQuoteModel) {
            val isSaved = isImageQuoteModelSaved.value
            isImageQuoteModelSaved = Node(imageQuoteModel, !isSaved)
        }
        return isImageQuoteModelSaved.value
    }
}

data class Node(val key: ImageQuoteModel, val value: Boolean)

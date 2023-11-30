package com.josecaballero.quoteswithpicture.feature.main.domain.usecase

import com.josecaballero.quoteswithpicture.feature.main.data.repostory.image.ImageRepo
import com.josecaballero.quoteswithpicture.feature.main.data.repostory.quote.QuoteRepo
import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import javax.inject.Inject

class GetImageQuoteModelUC @Inject constructor(
    private val imageRepo: ImageRepo,
    private val quoteRepo: QuoteRepo
) {

    private var nextImageQuoteModel: ImageQuoteModel? = null
    private var deferred: CompletableDeferred<Unit>? = CompletableDeferred()

    suspend operator fun invoke(): ImageQuoteModel {
        if (nextImageQuoteModel == null) {
            deferred?.let {
                if (it.isActive) it.cancel()
            }
            updateNewImageQuoteModel()
        }
        val imageQuoteModel = nextImageQuoteModel
        nextImageQuoteModel = null
        updateNewImageQuoteModelAsync()
        return imageQuoteModel!!
    }

    private suspend fun updateNewImageQuoteModel() {
        val quoteData = quoteRepo.getRemoteRandomQuote()
        val mostRepeatedWord = getMostRepeatedWord(quoteData.content) ?: quoteData.tag
        val imageData = imageRepo.getRemoteRandomQuote(mostRepeatedWord)
        nextImageQuoteModel = ImageQuoteModel.from(
            quoteData = quoteData,
            imageData = imageData
        )
    }

    private suspend fun updateNewImageQuoteModelAsync() {
        deferred?.let {
            CoroutineScope(Dispatchers.Default).launch {
                updateNewImageQuoteModel()
                it.complete(Unit)
            }
        }
    }

    private fun getMostRepeatedWord(sentence: String): String? {
        val words = sentence.split("\\s+".toRegex())
            .filter { it.length >= 4 }
        val wordCount = words.groupingBy { it }.eachCount()
        val mostCommon = wordCount.maxByOrNull { it.value }
        return if (mostCommon != null && mostCommon.value > 1) {
            mostCommon.key
        } else {
            words.maxByOrNull { it.length }
        }
    }
}

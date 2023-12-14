package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote

import androidx.lifecycle.ViewModel
import com.josecaballero.quoteswithpicture.feature.main.domain.usecase.GetImageQuoteModelUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import com.josecaballero.quoteswithpicture.feature.main.domain.model.ImageQuoteModel
import com.josecaballero.quoteswithpicture.feature.main.domain.usecase.SaveUnsaveImageQuoteUC
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.viewdata.ImageQuoteViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingScreenVM @Inject constructor(
    private val getImageQuoteModelUC: GetImageQuoteModelUC,
    private val saveUnsaveImageQuoteUC: SaveUnsaveImageQuoteUC
) : ViewModel() {

    private var getNextImageQuoteModelJob: Job? = null
    private var saveUnsaveImageQuoteJob: Job? = null

    private val _imageQuoteState = MutableStateFlow<States.ImageQuote>(States.ImageQuote.Initial)
    val imageQuoteState: StateFlow<States.ImageQuote> = _imageQuoteState.asStateFlow()

    private val _isImageQuoteSavedState =
        MutableStateFlow<States.ImageQuoteSaved>(States.ImageQuoteSaved.Data(false))
    val isImageQuoteSavedState: StateFlow<States.ImageQuoteSaved> =
        _isImageQuoteSavedState.asStateFlow()

    private lateinit var imageQuoteModel: ImageQuoteModel

    fun handleEvent(event: Events) {
        when (event) {
            is Events.ScreenInit -> getNextImageQuoteModel()
            is Events.NextQuote -> {
                getNextImageQuoteModel()
                resetIsImageQuoteSavedState()
            }

            is Events.SaveUnsave -> saveOrUnsaveImageQuoteModel()
        }
    }

    private fun getNextImageQuoteModel() {
        getNextImageQuoteModelJob?.cancel()
        getNextImageQuoteModelJob = viewModelScope.launch {
            _imageQuoteState.emit(States.ImageQuote.Loading)
            imageQuoteModel = getImageQuoteModelUC()
            val imageQuoteViewData = ImageQuoteViewData.from(imageQuoteModel)
            _imageQuoteState.emit(States.ImageQuote.Data(imageQuoteViewData))
        }
    }

    private fun saveOrUnsaveImageQuoteModel() {
        saveUnsaveImageQuoteJob?.cancel()
        saveUnsaveImageQuoteJob = viewModelScope.launch {
            val result = saveUnsaveImageQuoteUC(imageQuoteModel)
            _isImageQuoteSavedState.emit(States.ImageQuoteSaved.Data(result))
        }
    }

    private fun resetIsImageQuoteSavedState() {
        viewModelScope.launch {
            _isImageQuoteSavedState.emit(States.ImageQuoteSaved.Data(false))
        }
    }


    sealed class States {
        sealed class ImageQuote {
            object Initial : ImageQuote()
            object Loading : ImageQuote()
            data class Data(val data: ImageQuoteViewData) : ImageQuote()
        }

        sealed class ImageQuoteSaved {
            data class Data(val data: Boolean) : ImageQuoteSaved()
        }
    }

    sealed class Events {
        object ScreenInit : Events()
        object NextQuote : Events()
        object SaveUnsave : Events()
    }
}


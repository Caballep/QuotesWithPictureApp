package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing

import androidx.lifecycle.ViewModel
import com.josecaballero.quoteswithpicture.feature.main.domain.usecase.GetImageQuoteModelUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.viewdata.ImageQuoteViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingScreenVM @Inject constructor(
    private val getImageQuoteModelUC: GetImageQuoteModelUC
): ViewModel() {

    private var getNextImageQuoteModelJob: Job? = null
    private val _imageQuoteState = MutableStateFlow<States.ImageQuote>(States.ImageQuote.Initial)
    val imageQuoteState: StateFlow<States.ImageQuote> = _imageQuoteState.asStateFlow()

    fun handleEvent(event: Events) {
        when (event) {
            is Events.ScreenInit -> getNextImageQuoteModel()
            is Events.NextQuote -> getNextImageQuoteModel()
        }
    }

    private fun getNextImageQuoteModel() {
        getNextImageQuoteModelJob?.cancel()
        getNextImageQuoteModelJob = viewModelScope.launch {
            _imageQuoteState.emit(States.ImageQuote.Loading)
            val imageQuoteModel = getImageQuoteModelUC()
            val imageQuoteViewData = ImageQuoteViewData.from(imageQuoteModel)
            _imageQuoteState.emit(States.ImageQuote.Data(imageQuoteViewData))
        }
    }

    sealed class States {
        sealed class ImageQuote {
            object Initial: ImageQuote()
            object Loading: ImageQuote()
            data class Data(val data: ImageQuoteViewData): ImageQuote()
        }
    }

    sealed class Events {
        object ScreenInit: Events()
        object NextQuote: Events()
    }
}

package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.composable.DisplayImageQuote

@Composable
fun RandomQuoteScreen(viewModel: RandomQuoteScreenVM) {
    val imageQuoteState = viewModel.imageQuoteState.collectAsState().value
    val isImageQuoteSavedState = viewModel.isImageQuoteSavedState.collectAsState().value

    val isImageQuoteSaved =
        (isImageQuoteSavedState as RandomQuoteScreenVM.States.ImageQuoteSaved.Data).data

    LaunchedEffect(true) {
        viewModel.handleEvent(RandomQuoteScreenVM.Events.ScreenInit)
    }

    when (imageQuoteState) {
        is RandomQuoteScreenVM.States.ImageQuote.Initial -> {

        }

        is RandomQuoteScreenVM.States.ImageQuote.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
            )
        }

        is RandomQuoteScreenVM.States.ImageQuote.Data -> {
            DisplayImageQuote(
                imageQuoteState.data,
                isImageQuoteSaved,
                onSaveClicked = {
                    viewModel.handleEvent(RandomQuoteScreenVM.Events.SaveUnsave)
                },
                onNextClicked = {
                    viewModel.handleEvent(RandomQuoteScreenVM.Events.NextQuote)
                })
        }
    }
}

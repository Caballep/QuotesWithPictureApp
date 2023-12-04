package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.composable.DisplayImageQuote

@Composable
fun LandingScreen(viewModel: LandingScreenVM, navController: NavController) {
    val imageQuoteState = viewModel.imageQuoteState.collectAsState().value
    val isImageQuoteSavedState = viewModel.isImageQuoteSavedState.collectAsState().value

    val isImageQuoteSaved =
        (isImageQuoteSavedState as LandingScreenVM.States.ImageQuoteSaved.Data).data

    LaunchedEffect(true) {
        viewModel.handleEvent(LandingScreenVM.Events.ScreenInit)
    }

    when (imageQuoteState) {
        is LandingScreenVM.States.ImageQuote.Initial -> {

        }

        is LandingScreenVM.States.ImageQuote.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
            )
        }

        is LandingScreenVM.States.ImageQuote.Data -> {
            DisplayImageQuote(
                imageQuoteState.data,
                isImageQuoteSaved,
                onSaveClicked = {
                    viewModel.handleEvent(LandingScreenVM.Events.SaveUnsave)
                },
                onNextClicked = {
                    viewModel.handleEvent(LandingScreenVM.Events.NextQuote)
                })
        }
    }
}

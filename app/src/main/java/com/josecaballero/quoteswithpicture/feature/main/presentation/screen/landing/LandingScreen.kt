package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.josecaballero.quoteswithpicture.R
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.viewdata.ImageQuoteViewData

@Composable
fun LandingScreen(viewModel: LandingScreenVM) {
    val imageQuoteState = viewModel.imageQuoteState.collectAsState()

    LaunchedEffect(true) {
        viewModel.handleEvent(LandingScreenVM.Events.ScreenInit)
    }

    when (val state = imageQuoteState.value) {
        is LandingScreenVM.States.ImageQuote.Initial -> {
            // Do nothing for the initial state
        }
        is LandingScreenVM.States.ImageQuote.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
            )
        }
        is LandingScreenVM.States.ImageQuote.Data -> {
            DisplayImageQuote(state.data, onNextClicked = {
                viewModel.handleEvent(LandingScreenVM.Events.NextQuote)
            })
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DisplayImageQuote(imageQuoteData: ImageQuoteViewData, onNextClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = imageQuoteData.quote,
            fontSize = 24.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Author: ${imageQuoteData.author}",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        val painter = rememberImagePainter(
            data = imageQuoteData.imageUrl,
            builder = {
                crossfade(true) // Enable crossfade animation
                placeholder(R.drawable.ic_launcher_foreground) // Placeholder while loading (replace with your placeholder image)
            }
        )
        Image(
            painter = painter,
            contentDescription = "Image for the quote",
            modifier = Modifier
                .size(200.dp) // Adjust the size as needed
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = onNextClicked
        ) {
            Text(fontSize = 24.sp, text = "Next")
        }
    }
}

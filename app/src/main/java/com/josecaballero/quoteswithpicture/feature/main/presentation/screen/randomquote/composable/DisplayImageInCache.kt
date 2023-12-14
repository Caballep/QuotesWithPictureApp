package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.composable

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.josecaballero.quoteswithpicture.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DisplayCachedImage(imageUrl: String) {
    val painter = rememberImagePainter(
        data = imageUrl,
        builder = {
            fadeIn()
            placeholder(R.drawable.ic_launcher_foreground)
        }
    )

    Image(
        painter = painter,
        contentDescription = "Image for the quote",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
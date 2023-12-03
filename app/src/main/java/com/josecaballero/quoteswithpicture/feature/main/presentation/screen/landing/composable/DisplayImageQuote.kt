package com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.josecaballero.quoteswithpicture.R
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.viewdata.ImageQuoteViewData
import com.josecaballero.quoteswithpicture.feature.main.presentation.shared.OutlinedText

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DisplayImageQuote(
    imageQuoteData: ImageQuoteViewData,
    isImageQuoteSaved: Boolean,
    onSaveClicked: () -> Unit,
    onNextClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val painter = rememberImagePainter(
            data = imageQuoteData.imageUrl,
            builder = {
                crossfade(true)
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedText(
                text = imageQuoteData.quoteContent,
                color = imageQuoteData.textColorB,
                outlineColor = imageQuoteData.textColorA,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedText(
                text = imageQuoteData.quoteAuthor,
                color = imageQuoteData.textColorA,
                outlineColor = imageQuoteData.textColorB,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedText(
                text = "Photo by ${imageQuoteData.imagePhotographer}",
                color = imageQuoteData.textColorA,
                outlineColor = imageQuoteData.textColorB,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            Row {
                var saveButtonColors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray)
                var saveButtonText = "Save"
                if (isImageQuoteSaved) {
                    saveButtonColors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue)
                    saveButtonText = "Saved"
                }
                Button(
                    onClick = onSaveClicked,
                    colors = saveButtonColors
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.save),
                            contentDescription = "Save Image Quote"
                        )
                        Text(text = saveButtonText)
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(
                    onClick = onNextClicked,

                    ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.next),
                            contentDescription = ""
                        )
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

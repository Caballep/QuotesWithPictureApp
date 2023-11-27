package com.josecaballero.quoteswithpicture.feature.main.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedText(
    text: String,
    color: Color,
    outlineColor: Color,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default
) {
    val density = LocalDensity.current
    val shadowWidth = with(density) { 1.dp.toPx() }

    Text(
        fontSize = fontSize,
        text = text,
        style = style.copy(
            color = color,
            shadow = Shadow(
                color = outlineColor,
                offset = androidx.compose.ui.geometry.Offset(-shadowWidth, -shadowWidth),
                blurRadius = 0f
            )
        ),
    )
}

package com.josecaballero.quoteswithpicture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.josecaballero.quoteswithpicture.core.ui.theme.QuotesWithPictureTheme
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.LandingScreen
import com.josecaballero.quoteswithpicture.feature.main.presentation.shared.LoopingVerticalPagerExample
import com.josecaballero.quoteswithpicture.feature.main.presentation.shared.VerticalViewPagerExample
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesWithPictureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingScreen(viewModel = hiltViewModel())
                    //VerticalViewPagerExample()
                    //LoopingVerticalPagerExample()
                }
            }
        }
    }
}

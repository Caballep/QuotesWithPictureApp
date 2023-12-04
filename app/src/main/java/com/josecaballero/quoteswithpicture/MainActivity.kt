package com.josecaballero.quoteswithpicture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.josecaballero.quoteswithpicture.core.ui.theme.QuotesWithPictureTheme
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.LandingScreen
import com.josecaballero.quoteswithpicture.feature.main.presentation.shared.BottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.layout.padding


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesWithPictureTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Scaffold(
                            bottomBar = { BottomNavigationBar() },
                            content = { padding ->
                                Surface(modifier =  Modifier.padding(padding)) {
                                    LandingScreen(
                                        viewModel = hiltViewModel(),
                                        navController = navController
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

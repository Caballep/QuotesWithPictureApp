package com.josecaballero.quoteswithpicture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.josecaballero.quoteswithpicture.core.ui.theme.QuotesWithPictureTheme
import com.josecaballero.quoteswithpicture.infrastructure.navigation.presentation.MainBottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.layout.padding
import com.josecaballero.quoteswithpicture.infrastructure.navigation.MainNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesWithPictureTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { MainBottomNavigationBar(navController = navController) },
                    content = { padding ->
                        Surface(modifier = Modifier.padding(padding)) {
                            MainNavigation(navController)
                        }
                    }
                )
            }
        }
    }
}

package com.josecaballero.quoteswithpicture.infrastructure.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.landing.LandingScreen
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.savedquotes.SavedQuotesScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingScreen(viewModel = hiltViewModel(), navController = navController)
        }
        composable("savedQuotes") {
            SavedQuotesScreen(viewModel = hiltViewModel(), navController = navController)
        }
    }
}

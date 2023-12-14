package com.josecaballero.quoteswithpicture.infrastructure.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.randomquote.RandomQuoteScreen
import com.josecaballero.quoteswithpicture.feature.main.presentation.screen.savedquotes.SavedQuotesScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Main.RANDOM_QUOTE.route) {
        composable(Destinations.Main.RANDOM_QUOTE.route) {
            RandomQuoteScreen(viewModel = hiltViewModel())
        }
        composable(Destinations.Main.SAVED_QUOTES.route) {
            SavedQuotesScreen(viewModel = hiltViewModel())
        }
    }
}

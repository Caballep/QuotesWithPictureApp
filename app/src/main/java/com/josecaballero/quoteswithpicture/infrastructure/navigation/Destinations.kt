package com.josecaballero.quoteswithpicture.infrastructure.navigation

sealed class Destinations {

    enum class Main(val route: String) {
        RANDOM_QUOTE("randomQuote"),
        SAVED_QUOTES("savedQuotes")
    }
}

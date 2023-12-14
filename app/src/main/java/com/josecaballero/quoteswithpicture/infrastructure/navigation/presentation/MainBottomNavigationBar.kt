package com.josecaballero.quoteswithpicture.infrastructure.navigation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.josecaballero.quoteswithpicture.infrastructure.navigation.Destinations
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun MainBottomNavigationBar(navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(0) }
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                        navController.navigate(item.destination)
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}

val items = listOf(
    BottomNavigation(
        title = "Random",
        icon = Icons.Rounded.Refresh,
        destination = Destinations.Main.RANDOM_QUOTE.route
    ),
    BottomNavigation(
        title = "Saved",
        icon = Icons.Rounded.Favorite,
        destination = Destinations.Main.SAVED_QUOTES.route
    )
)

data class BottomNavigation(
    val title: String,
    val icon: ImageVector,
    val destination: String
)

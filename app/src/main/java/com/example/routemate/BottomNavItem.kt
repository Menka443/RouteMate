package com.example.routemate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search : BottomNavItem(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Trips : BottomNavItem(
        route = "trips",
        title = "Trips",
        icon = Icons.Default.Home
    )

    object Chat : BottomNavItem(
        route = "chat",
        title = "Chat",
        icon = Icons.Default.Chat
    )

    object Profile : BottomNavItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
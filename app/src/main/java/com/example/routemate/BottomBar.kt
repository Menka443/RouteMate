package com.example.routemate

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState



@Composable
fun BottomBar(
    navController: NavController
) {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Trips,
        BottomNavItem.Chat,
        BottomNavItem.Profile
    )

    NavigationBar {

        val current = navController.currentBackStackEntryAsState()

        val currentRoute = current.value?.destination?.route

        items.forEach { item ->

            NavigationBarItem(

                selected = currentRoute == item.route,

                onClick = {

                    navController.navigate(item.route)

                },

                icon = {

                    Icon(
                        item.icon,
                        contentDescription = item.title
                    )

                },

                label = {

                    Text(item.title)

                }

            )

        }

    }

}
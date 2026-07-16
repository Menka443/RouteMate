package com.example.routemate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.routemate.homeComponent.BestMatchCard
import com.example.routemate.homeComponent.PeopleGoingYourWay
import com.example.routemate.homeComponent.TodayRouteCard
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {


    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }

    ) { innerPadding ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)   // ✅ Use this
                .background(Color(0xFFF5F9FF))
                .padding(16.dp)

        ) {

            item {

                TopSection()

                Spacer(modifier = Modifier.height(20.dp))

                TodayRouteCard()

                Spacer(modifier = Modifier.height(20.dp))

                BestMatchCard()

                Spacer(modifier = Modifier.height(20.dp))

                PeopleGoingYourWay()

            }

        }
    }

}
package com.example.routemate.homeComponent

//package com.example.routemate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.routemate.CommuterCard

@Composable
fun PeopleGoingYourWay() {

    androidx.compose.material3.Text(

        text = "People Going Your Way"

    )

    repeat(5) {

        CommuterCard(

            name = "Rahul",

            destination = "Sector 14",

            time = "6:10 PM",

            match = "92%"

        )

    }

}
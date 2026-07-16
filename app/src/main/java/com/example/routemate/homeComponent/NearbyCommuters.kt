package com.example.routemate.homeComponent



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.IconButton
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NearbyCommuters() {

    Text(

        text = "Nearby Commuters",

        fontWeight = FontWeight.Bold,

        fontSize = 20.sp

    )

    Spacer(modifier = Modifier.height(10.dp))

    repeat(3) {

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)

        ) {

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Column {

                    Text(
                        "Rahul",
                        fontWeight = FontWeight.Bold
                    )

                    Text("Google")

                    Text("⭐ 4.9")

                }

                Text("2 km")

            }

        }

    }

}
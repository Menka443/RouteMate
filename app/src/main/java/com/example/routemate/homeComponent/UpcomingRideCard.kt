package com.example.routemate.homeComponent
//package com.example.routemate

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
fun UpcomingRideCard() {

    Text(

        text = "Upcoming Ride",

        fontWeight = FontWeight.Bold,

        fontSize = 20.sp

    )

    Spacer(modifier = Modifier.height(10.dp))

    Card(

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text("📍 Rohini → Gurugram")

            Spacer(modifier = Modifier.height(8.dp))

            Text("🕘 09:00 AM")

            Spacer(modifier = Modifier.height(8.dp))

            Text("🚗 White Swift")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Driver : Rahul")

        }

    }

}
package com.example.routemate.homeComponent

//package com.example.routemate

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BestMatchCard() {

    Text(

        "⭐ Best Match",

        fontWeight = FontWeight.Bold

    )

    Spacer(modifier = Modifier.height(10.dp))

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(18.dp)

    ) {

        Column(

            modifier = Modifier.padding(20.dp)

        ) {

            Text("👨 Priyam")

            Text("📍 Sector 12 (300m away)")

            Text("🏢 Cyber City")

            Text("🕕 Leaving 6:05 PM")

            Text("⭐ 98% Route Match")

            Spacer(modifier = Modifier.height(12.dp))

            Button(

                onClick = {}

            ) {

                Text("Message")

            }

        }

    }

}
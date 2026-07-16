package com.example.routemate.homeComponent



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodayRouteCard() {

    Card(

        shape = RoundedCornerShape(20.dp),

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier.padding(20.dp)

        ) {

            Text(
                "Today's Commute"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("📍 Sector 12, Gurugram")

            Text("⬇")

            Text("🏢 Cyber City")

            Spacer(modifier = Modifier.height(16.dp))

            Row {

                Icon(
                    Icons.Default.Schedule,
                    null
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text("Leaving Today at 6:00 PM")

            }

        }

    }

}
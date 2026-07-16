package com.example.routemate

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun TopSection() {

    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    val greeting = when {

        hour < 12 -> "☀ Good Morning"

        hour < 17 -> "🌤 Good Afternoon"

        else -> "🌆 Good Evening"

    }

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,

        verticalAlignment = Alignment.CenterVertically

    ) {

        Column {

            Text(
                greeting
            )

            Text(

                "Nikki",

                fontSize = 28.sp,

                fontWeight = FontWeight.Bold

            )

        }

        Row {

            IconButton(onClick = {}) {

                Icon(
                    Icons.Default.Notifications,
                    null
                )

            }

            IconButton(onClick = {}) {

                Icon(
                    Icons.Default.Person,
                    null
                )

            }

        }

    }

}
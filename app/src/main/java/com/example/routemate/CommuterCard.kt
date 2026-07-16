package com.example.routemate

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CommuterCard(

    name: String,

    destination: String,

    time: String,

    match: String

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        shape = RoundedCornerShape(18.dp)

    ) {

        Row(

            modifier = Modifier.padding(18.dp),

            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column {

                Text(name)

                Text(destination)

                Text(time)

            }

            Button(

                onClick = {}

            ) {

                Text(match)

            }

        }

    }

}
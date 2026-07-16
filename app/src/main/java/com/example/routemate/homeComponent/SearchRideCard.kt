package com.example.routemate.homeComponent



import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.IconButton
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchRideCard() {

    Card(

        shape = RoundedCornerShape(20.dp),

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            OutlinedTextField(

                value = "",

                onValueChange = {},

                modifier = Modifier.fillMaxWidth(),

                label = {

                    Text("From")

                }

            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(

                value = "",

                onValueChange = {},

                modifier = Modifier.fillMaxWidth(),

                label = {

                    Text("Destination")

                }

            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(

                onClick = {},

                modifier = Modifier.fillMaxWidth()

            ) {

                Icon(Icons.Default.Search, null)

                Spacer(modifier = Modifier.width(8.dp))

                Text("Find Ride")

            }

        }

    }

}
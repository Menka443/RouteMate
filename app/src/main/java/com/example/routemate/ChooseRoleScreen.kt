package com.example.routemate



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.border
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseRoleScreen(

    onContinueClick: (String) -> Unit = {}

) {

    var selectedRole by remember {

        mutableStateOf("")

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(

            text = "Choose Your Role",

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(

            text = "How do you usually commute?",

            color = Color.Gray

        )

        Spacer(modifier = Modifier.height(40.dp))

        RoleCard(

            title = "Driver",

            description = "Offer rides and earn money.",

            icon = Icons.Default.DirectionsCar,

            selected = selectedRole == "Driver"

        ) {

            selectedRole = "Driver"

        }

        Spacer(modifier = Modifier.height(20.dp))

        RoleCard(

            title = "Passenger",

            description = "Find rides and save money.",

            icon = Icons.Default.Person,

            selected = selectedRole == "Passenger"

        ) {

            selectedRole = "Passenger"

        }

        Spacer(modifier = Modifier.weight(1f))

        Button(

            onClick = {

                onContinueClick(selectedRole)

            },

            enabled = selectedRole.isNotEmpty(),

            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)

        ) {

            Text("Continue")

        }

        Spacer(modifier = Modifier.height(20.dp))

    }

}
package com.example.routemate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompleteProfileScreen(

    onContinueClick: () -> Unit = {}

) {

    var fullName by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var home by remember { mutableStateOf("") }
    var office by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("09:00 AM") }
    var returnTime by remember { mutableStateOf("06:00 PM") }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color(0xFFEAF5FF)
                    )
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Complete Your Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Let's personalize your commute",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable { },

            contentAlignment = Alignment.Center
        ) {

            Icon(
                Icons.Default.CameraAlt,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        ProfileTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name",
            icon = Icons.Default.Person
        )

        ProfileTextField(
            value = company,
            onValueChange = { company = it },
            label = "Company",
            icon = Icons.Default.Business
        )

        ProfileTextField(
            value = home,
            onValueChange = { home = it },
            label = "Home Location",
            icon = Icons.Default.Home
        )

        ProfileTextField(
            value = office,
            onValueChange = { office = it },
            label = "Office Location",
            icon = Icons.Default.LocationOn
        )

        Spacer(modifier = Modifier.height(10.dp))

        ProfileTextField(
            value = departure,
            onValueChange = {},
            label = "Departure Time",
            icon = Icons.Default.AccessTime
        )

        ProfileTextField(
            value = returnTime,
            onValueChange = {},
            label = "Return Time",
            icon = Icons.Default.AccessTime
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = onContinueClick,

            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),

            shape = RoundedCornerShape(16.dp)

        ) {

            Text(
                "Continue",
                fontSize = 18.sp
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

    }

}
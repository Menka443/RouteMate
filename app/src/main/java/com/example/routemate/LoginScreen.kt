package com.example.routemate



import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import com.example.routemate.login.LoginState
import com.example.routemate.login.LoginViewModel
import com.example.routemate.signUp.SignupState

@Composable
fun LoginScreen(
   viewModel: LoginViewModel,
   onLoginClick: () ->Unit,
   onSignUpClick: () ->Unit
) {

    val state by viewModel.state.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color(0xFFEFF6FF)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Welcome Back 👋",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Find your daily commute partner",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(

                value = email,
                onValueChange = { email = it },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Email")
                },

                leadingIcon = {
                    Icon(Icons.Default.Email, null)
                },

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),

                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(

                value = password,
                onValueChange = { password = it },

                modifier = Modifier.fillMaxWidth(),

                label = {
                    Text("Password")
                },

                leadingIcon = {
                    Icon(Icons.Default.Lock, null)
                },

                trailingIcon = {

                    IconButton(
                        onClick = {
                            showPassword = !showPassword
                        }
                    ) {

                        Icon(
                            if (showPassword)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,
                            null
                        )

                    }

                },

                visualTransformation =
                if (showPassword)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),

                shape = RoundedCornerShape(16.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                "Forgot Password?",

                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { },

                color = Color(0xFF1F7BFF)

            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                enabled = state !is LoginState.Loading,

                onClick = {
                    Log.d("LOGIN", "Button Clicked")

                    viewModel.login(
                        email = email,
                        password = password
                    )
                },


                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),

                shape = RoundedCornerShape(16.dp),


                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1F7BFF)


                )

            ) {

                if (state is LoginState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        strokeWidth = 2.dp,
                        color = Color.White
                    )
                } else {

                    Text(
                        "Login",
                        fontSize = 18.sp
                    )

                }
            }
            if(state is LoginState.Error){
                Text(
                    text = (state as LoginState.Error).message,
                    color = Color.Red
                )
            }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    "────────  OR  ────────",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(25.dp))

                OutlinedButton(

                    onClick = {},

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),

                    shape = RoundedCornerShape(16.dp)

                ) {

                    Text("Continue with Google")

                }

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedButton(

                    onClick = {},

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),

                    shape = RoundedCornerShape(16.dp)

                ) {

                    Text("Continue with Phone")

                }

                Spacer(modifier = Modifier.weight(1f))

                Row {

                    Text("Don't have an account? ")

                    Text(
                        "Sign Up",
                        color = Color(0xFF1F7BFF),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            onSignUpClick()
                        }
                    )

                }

                Spacer(modifier = Modifier.height(20.dp))

            }
            LaunchedEffect(state) {
                if(state is LoginState.Success){
                    onLoginClick()
                }
            }



    }

    }

package com.example.routemate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.routemate.signUp.SignupState
import com.example.routemate.signUp.SignupViewModel

@Composable
fun SignUpScreen(
    viewModel: SignupViewModel,
    onSignupSuccess: () -> Unit,
    onBackToLogin: () -> Unit,
    onLoginClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {}
)

{

    val state by viewModel.state.collectAsState()
    /************** UI *************************/
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var home by remember { mutableStateOf("") }
    var office by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var agree by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color.White, Color(0xFFEAF5FF))
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(90.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Create Account",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Join the smart commuting community",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppTextField(
            value = name,
            onValueChange = { name = it },
            label = "Full Name",
            icon = Icons.Default.Person
        )

        AppTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email
        )

        AppTextField(
            value = phone,
            onValueChange = { phone = it },
            label = "Phone Number",
            icon = Icons.Default.Phone,
            keyboardType = KeyboardType.Phone
        )

        AppTextField(
            value = company,
            onValueChange = { company = it },
            label = "Company",
            icon = Icons.Default.Business
        )

        AppTextField(
            value = home,
            onValueChange = { home = it },
            label = "Home Location",
            icon = Icons.Default.Home
        )

        AppTextField(
            value = office,
            onValueChange = { office = it },
            label = "Office Location",
            icon = Icons.Default.LocationOn
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") },
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

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Confirm Password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, null)
            },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = agree,
                onCheckedChange = {
                    agree = it
                }
            )

            Text("I agree to Terms & Conditions")

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.signUp(
                    name = name,
                    email = email,
                    phone = phone,
                    company = company,
                    home = home,
                    office = office,
                    password = password,
                    confirmPassword = confirmPassword,
                    agree = agree

                )
            },
            enabled = agree && state !is SignupState.Loading,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            if(state is SignupState.Loading){
                CircularProgressIndicator(
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 2.dp,
                    color = Color.White


                )
            }else {

                Text("Create Account")
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {

            Text("Continue with Google")

        }

        Spacer(modifier = Modifier.height(24.dp))

        Row {

            Text("Already have an account? ")

            Text(
                "Login",
                color = Color(0xFF1565C0),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
//                    onLoginClick()
                    onBackToLogin()
                }
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
    }
    LaunchedEffect(state) {
        if (state is SignupState.Success) {
            onSignupSuccess()
        }
    }

}
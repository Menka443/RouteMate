package com.example.routemate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.routemate.ui.theme.RouteMateTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val options = FirebaseApp.getInstance().options

        Log.d("FIREBASE", "ProjectId = ${options.projectId}")
        Log.d("FIREBASE", "ApplicationId = ${options.applicationId}")
        Log.d("FIREBASE", "ApiKey = ${options.apiKey}")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            RouteMateTheme {
                AppNavigation()
            }


        }

    }
}


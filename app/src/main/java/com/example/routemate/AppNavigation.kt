package com.example.routemate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.traceEventEnd
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.routemate.Routes.HOME
import com.example.routemate.login.LoginViewModel
import com.example.routemate.search.SearchScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.routemate.signUp.SignupViewModel
import kotlin.math.log

@Composable
fun AppNavigation() {
    // Create a NavController to manage navigation between screens
    val navController = rememberNavController()
    // NavHost is the container that holds all screens
    NavHost(
        navController = navController,
        // First screen when app starts
        startDestination = Routes.SPLASH
    ) {


        /************************* Splash Screen ********************************/
        composable(Routes.SPLASH) {
            SplashScreen(
                // Called after splash delay (2-3 seconds)
                onNavigate = {
                    // Navigate to Login Screen
                    navController.navigate(Routes.LOGIN) {
                        // Remove Splash Screen from back stack
                        // So pressing back won't return to splash
                        popUpTo(Routes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }


        /*************************** Login Screen *****************************/
        composable(Routes.LOGIN) {
            val loginViewModel: LoginViewModel = viewModel()
            LoginScreen(
                viewModel = loginViewModel,
                // User clicks Login button
                onLoginClick = {
                    // Navigate to Home Screen
                    navController.navigate(Routes.HOME)

                },
                // User clicks Sign Up
                onSignUpClick = {
                    // Navigate to Sign Up Screen
                    navController.navigate(Routes.SIGNUP)

                }

            )

        }


        /*************** Sign Up Screen *********************/
        composable(Routes.SIGNUP) {
            val signupViewModel: SignupViewModel = viewModel()
            SignUpScreen(
                // Already have an account?
                viewModel = signupViewModel,
                onSignupSuccess = {
                    navController.navigate(Routes.HOME){
                        popUpTo(Routes.SIGNUP){
                            inclusive = true
                        }
                    }
                },

                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }


        /************* Complete Profile Screen ***************/
        composable(Routes.COMPLETE_PROFILE) {
            CompleteProfileScreen(
                onContinueClick = {
                    // Navigate to Choose Role Screen
                    navController.navigate(Routes.CHOOSE_ROLE)

                }

            )

        }


        /************** Choose Role Screen ******************/
        composable(Routes.CHOOSE_ROLE) {
            ChooseRoleScreen(
                onContinueClick = { role ->
                    // If user selected Driver
                    if (role == "Driver") {
                        // Open Vehicle Details Screen
                        navController.navigate(Routes.VEHICLE_DETAILS)
                    } else {
                        // Passenger goes directly to Home
                        navController.navigate(Routes.HOME)

                    }

                }

            )

        }


        /**************** Vehicle Details Screen *******************/
        composable(Routes.VEHICLE_DETAILS) {
            VehicleDetailsScreen()

        }


        /**************** Home Screen **********************/
        composable(Routes.HOME) {
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(
                navController = navController,
                viewModel = homeViewModel
                
            )

        }
        composable(Routes.SEARCH_SCREEN){
            SearchScreen()
        }


    }

}
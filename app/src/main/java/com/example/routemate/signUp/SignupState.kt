package com.example.routemate.signUp

sealed class SignupState {

    data object Idle: SignupState()
    data object Loading: SignupState()
    data object Success: SignupState()

    data class Error(val message: String): SignupState()


}
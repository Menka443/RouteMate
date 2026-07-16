package com.example.routemate

import com.example.routemate.signUp.User

sealed class HomeState {

    object Loading: HomeState()

    data class Success(
        val currentUser: User?,
        val users: List<User>
    ): HomeState()

    data class Error(
        val message: String
    ): HomeState()

}
package com.example.routemate.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routemate.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val repository = AuthRepository()

    private val _state = MutableStateFlow<LoginState>(LoginState.Idle)

    val state = _state.asStateFlow()

    fun login(email: String, password: String){
        viewModelScope.launch{
            _state.value = LoginState.Loading

            try{
                repository.login(
                    email,
                    password
                )
                _state.value = LoginState.Success
            }catch(e: Exception){
                _state.value = LoginState.Error(
                    e.message ?: "Login failed"
                )
            }
        }
    }
}
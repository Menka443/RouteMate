package com.example.routemate

import com.example.routemate.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)

    val state = _state.asStateFlow()

    init{
        loadUsers()
    }

    private fun loadUsers(){

        viewModelScope.launch{
            try{

                val currentUser = repository.getCurrentUser()
                val users = repository.getAllUsers()

                _state.value = HomeState.Success(
                    currentUser = currentUser,
                    users = users
                )
            }catch(e: Exception){
                _state.value = HomeState.Error(
                    e.message ?:"Something went wring"
                )
            }
        }
    }
}
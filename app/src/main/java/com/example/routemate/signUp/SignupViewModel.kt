package com.example.routemate.signUp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routemate.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignupViewModel: ViewModel() {
    private val repository = AuthRepository()

    private val _state = MutableStateFlow<SignupState>(SignupState.Idle)

    val state = _state.asStateFlow()

    fun signUp(
        name: String,
        email: String,
        phone: String,
        company: String,
        home: String,
        office: String,
        password: String,
        confirmPassword: String,
        agree: Boolean


    ){
        //validate
        if(name.isBlank()){
            _state.value = SignupState.Error("Enter your name")
            return
        }

        if (email.isBlank()) {
            _state.value = SignupState.Error("Enter email")
            return
        }

        if (phone.isBlank()) {
            _state.value = SignupState.Error("Enter phone number")
            return
        }

        if (password != confirmPassword) {
            _state.value =
                SignupState.Error("Passwords do not match")
            return
        }

        if (!agree) {
            _state.value =
                SignupState.Error("Accept Terms & Conditions")
            return
        }

        viewModelScope.launch {
            _state.value = SignupState.Loading

            try{

                repository.signUp(

                    name = name,
                    email = email,
                    phone = phone,
                    company = company,
                    home = home,
                    office = office,
                    password = password

                )
                _state.value = SignupState.Success
            }catch (e: Exception){
                Log.e("SIGNUP", "Signup failed", e)
                _state.value = SignupState.Error(
                    e.message ?: "Signup Failed"
                )
            }
        }



    }


}
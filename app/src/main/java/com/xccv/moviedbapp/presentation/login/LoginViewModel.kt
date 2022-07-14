package com.xccv.moviedbapp.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.xccv.moviedbapp.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import logcat.logcat
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    private val _loginState = mutableStateOf(value = false)
    val loginState = _loginState

    init {
        logcat("BlertonTest") { "onInit" }
        viewModelScope.launch(Dispatchers.IO) { repository.updateRequestToken() }
    }

    fun login(username: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            logcat("BlertonTest") { "userName = $username, password = $password" }

            try {
                val result = repository.getValidationFromLogin(
                    username = username,
                    password = password
                )

                _loginState.value = result.success

            } catch (e: HttpException) {
                _loginState.value = false
            }
        }
    }

}
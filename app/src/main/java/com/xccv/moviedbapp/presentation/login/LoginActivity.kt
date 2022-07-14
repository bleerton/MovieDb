package com.xccv.moviedbapp.presentation.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.xccv.moviedbapp.presentation.NavigationScreen
import dagger.hilt.android.AndroidEntryPoint
import logcat.logcat

@OptIn(ExperimentalFoundationApi::class)
@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel: LoginViewModel by viewModels()
        setContent {
            LoginOnboarding(loginViewModel) {
                Surface(color = MaterialTheme.colors.background) {
                    logcat("BlertonTest") { "NavigationScreen" }
                    NavigationScreen()
                }
            }
        }
    }
}
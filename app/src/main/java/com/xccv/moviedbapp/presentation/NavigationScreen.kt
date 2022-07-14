package com.xccv.moviedbapp.presentation

import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xccv.moviedbapp.presentation.login.LoginViewModel
import com.xccv.moviedbapp.presentation.main.MainActivity

@Composable
fun NavigationScreen(viewModel: LoginViewModel = hiltViewModel()) {

    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {

        composable(route = Destination.Login.route) {
            if (viewModel.loginState.value){
                context.startActivity(Intent(context, MainActivity::class.java))
            }
            else {
                val text = "Failed to log in. Check your username and/or password"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
        }

    }
}
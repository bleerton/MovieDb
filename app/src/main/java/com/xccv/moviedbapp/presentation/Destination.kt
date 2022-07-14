package com.xccv.moviedbapp.presentation

sealed class Destination(val route: String) {
    object Login : Destination(route = "login")
    object Home : Destination(route = "home")

    companion object {
        fun getStartDestination() = Login.route
    }
}

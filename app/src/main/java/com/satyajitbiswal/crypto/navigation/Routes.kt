package com.satyajitbiswal.crypto.navigation

sealed class Routes(val route: String) {

    data object Home: Routes("Home")
    data object Details: Routes("Details")

}
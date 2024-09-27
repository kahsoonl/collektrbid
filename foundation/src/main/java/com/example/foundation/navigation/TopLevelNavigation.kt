package com.example.foundation.navigation

import androidx.navigation.NavHostController

/**
 * Model the navigation top-level actions within the app.
 */
class TopLevelNavigation(private val navController: NavHostController) {
    fun navigateTo(destination: NavigationCommand) {
        topLevelNavigate(navController = navController, route = destination.route)
    }
}

package com.example.foundation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Navigation Controller - It handles all push and pop operations.
 */
fun navigateToDestination(
    navObject: NavCommandWithArgs,
    navController: NavHostController,
) {
    when (navObject.command.route) {
        NavigationCommand.PopBackStack.route -> navController.managePopOperations()

        NavigationCommand.BidOverview.route,
        -> checkNavArgsAndNavigate(
            navObject = navObject,
            navController = navController,
            popUpToRoute = navController.currentBackStackEntry?.destination?.route,
            inclusiveFlag = true,
            popUpToFlag = true,
        )

        else -> {
            checkNavArgsAndNavigate(
                navObject = navObject,
                navController = navController,
            )
        }
    }
}

/**
 * Manage all pop operations.
 */
private fun NavHostController.managePopOperations() {
    navigateBack(navController = this)
}

/**
 * Navigate to the destination.
 * @param navObject - It contains route along with it's arguments.
 * @param navController - NavController.
 * @param popUpToRoute - Removes destinations up to given destination.
 * @param inclusiveFlag - Given route should be pop from stack or not.
 * @param popUpToFlag - It maintains if [popUpToRoute] should be used or not.
 */
private fun checkNavArgsAndNavigate(
    navObject: NavCommandWithArgs,
    navController: NavHostController,
    popUpToRoute: String? = null,
    inclusiveFlag: Boolean = false,
    popUpToFlag: Boolean = false,
) {
    val argument = navObject.arguments
    var route = navObject.command.route
    if (argument != null) {
        // To handle multiple argument case, should be list of String
        if (argument is List<*>) {
            argument.forEach {
                route = route.plus("/").plus(it)
            }
        } else {
            route = route.plus("/").plus(argument)
        }
    }

    navigate(
        navController = navController,
        route = route,
        popUpToRoute = popUpToRoute,
        inclusiveFlag = inclusiveFlag,
        popUpToFlag = popUpToFlag,
    )
}

private fun navigate(
    navController: NavController,
    route: String,
    launchSingleTopFlag: Boolean = true,
    popUpToRoute: String? = null,
    popUpToFlag: Boolean = false,
    inclusiveFlag: Boolean = false,
) {
    navController.navigate(route) {
        launchSingleTop = launchSingleTopFlag
        if (popUpToFlag) {
            if (popUpToRoute.isNullOrEmpty().not()) {
                popUpTo(popUpToRoute.toString()) {
                    inclusive = inclusiveFlag
                }
            } else {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = inclusiveFlag
                }
            }
        }
    }
}

/**
 * Navigate back.
 * @param navController - [NavHostController]
 */
private fun navigateBack(navController: NavHostController) {
    navController.popBackStack()
}
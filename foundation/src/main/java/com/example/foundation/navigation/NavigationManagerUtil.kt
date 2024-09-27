package com.example.foundation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.foundation.navigation.utility.bottomTabList

/**
 * Navigation Controller - It handles all push and pop operations.
 */
fun navigateToDestination(
    navObject: NavigationCommand,
    navController: NavHostController,
) {
    when (navObject.route) {
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
    navObject: NavigationCommand,
    navController: NavHostController,
    popUpToRoute: String? = null,
    inclusiveFlag: Boolean = false,
    popUpToFlag: Boolean = false,
) {
    val route = navObject.route

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

/**
 * This is the top-level Navigation.
 */
fun topLevelNavigate(
    navController: NavHostController,
    route: String,
    restoreStateFlag: Boolean = true,
    saveStateFlag: Boolean = true,
    clearBackStack: Boolean = false,
) {
    if (clearBackStack) {
        // Clear backstack first before restoring the state of the top-level navigation.
        navController.clearBackStack(route)
    }
    navController.navigate(route) {
        val navigationRoutes = bottomTabList.map { it.route }
        val firstBottomBarDestination = navController.currentBackStack.value.firstOrNull {
            navigationRoutes.contains(it.destination.route)
        }?.destination
        // Remove all navigation items from the stack,
        // so that only the currently-selected screen remains in the stack.
        if (firstBottomBarDestination != null) {
            popUpTo(firstBottomBarDestination.id) {
                inclusive = true
                saveState = saveStateFlag
            }
        }
        // Avoid multiple copies of the same destination when re-selecting the same item.
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item.
        restoreState = restoreStateFlag
    }
}

fun NavHostController.popBottomTabsInstances() {
    bottomTabList.forEach {
        clearBackStack(it.route)
    }
}

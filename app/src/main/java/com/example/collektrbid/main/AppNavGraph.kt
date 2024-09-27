package com.example.collektrbid.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.foundation.navigation.NavigationManager
import com.example.foundation.navigation.utility.defaultEnterTransition
import com.example.foundation.navigation.utility.defaultExitTransition
import com.example.foundation.navigation.utility.defaultPopEnterTransition
import com.example.foundation.navigation.utility.defaultPopExitTransition
import com.example.collektrbid.graph.bidNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(
    startDestination: MutableState<String>,
    navController: NavHostController = rememberNavController(),
    navigationManager: NavigationManager,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.value,
        enterTransition = { defaultEnterTransition(initialState, targetState) },
        exitTransition = { defaultExitTransition(initialState, targetState) },
        popEnterTransition = { defaultPopEnterTransition(initialState, targetState) },
        popExitTransition = { defaultPopExitTransition(initialState, targetState) },
    ) {
        bidNavGraph(navigationManager)
    }
}
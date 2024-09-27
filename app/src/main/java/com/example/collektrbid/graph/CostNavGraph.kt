package com.example.collektrbid.graph

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bid.overview.BidOverviewDestination
import com.example.bid.overview.viewmodel.BidOverviewViewModel
import com.example.foundation.navigation.NavigationCommand
import com.example.foundation.navigation.NavigationManager

fun NavGraphBuilder.bidNavGraph(
    navigationManager: NavigationManager,
) {
    navigation(
        startDestination = NavigationCommand.BidOverviewDestination,
        route = NavigationCommand.BidOverviewRoute,
    ) {
        bidOverviewGraph(navigationManager)
    }
}

private fun NavGraphBuilder.bidOverviewGraph(
    navigationManager: NavigationManager,
) {
    composable(route = NavigationCommand.BidOverview.destination) {
        val bidOverviewViewModel : BidOverviewViewModel = hiltViewModel()
        val bidOverviewNavEffect = bidOverviewViewModel.effect
        val bidOverviewViewState by bidOverviewViewModel.viewState.collectAsState()

        BidOverviewDestination(
            viewModel = bidOverviewViewModel,
            viewState = bidOverviewViewState.bidOverviewViewState,
            navEffect = bidOverviewNavEffect,
            navigationManager = navigationManager,
        )
    }
}
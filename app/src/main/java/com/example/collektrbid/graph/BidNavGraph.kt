package com.example.collektrbid.graph

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.bid.detail.BidDetailDestination
import com.example.bid.detail.viewmodel.BidDetailViewModel
import com.example.bid.overview.BidOverviewDestination
import com.example.bid.overview.viewmodel.BidOverviewViewModel
import com.example.foundation.interaction.util.emptyValue
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
        bidDetailGraph(navigationManager)
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

private fun NavGraphBuilder.bidDetailGraph(
    navigationManager: NavigationManager,
) {
    composable(
        route = "${NavigationCommand.BidDetail.route}/{${NavigationCommand.BidDetailCollectableIdArgs}}",
        arguments = NavigationCommand.BidDetail.arguments,
    ) {
        val bidDetailViewModel: BidDetailViewModel = hiltViewModel()
        val bidDetailNavEffect = bidDetailViewModel.effect
        val bidDetailViewState by bidDetailViewModel.viewState.collectAsState()
        val collectableId =
            it.arguments?.getInt(NavigationCommand.BidDetailCollectableIdArgs) ?: Int.emptyValue()

        BidDetailDestination(
            viewModel = bidDetailViewModel,
            viewState = bidDetailViewState.bidDetailViewState,
            navEffect = bidDetailNavEffect,
            navigationManager = navigationManager,
            collectableId = collectableId,
        )
    }
}
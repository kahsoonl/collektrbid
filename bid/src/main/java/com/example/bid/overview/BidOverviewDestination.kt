package com.example.bid.overview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.bid.overview.view.BidOverviewDataLoaded
import com.example.bid.overview.view.screen.BidOverviewInitialLoading
import com.example.bid.overview.viewmodel.BidOverviewNavEffect
import com.example.bid.overview.viewmodel.BidOverviewUserIntent
import com.example.bid.overview.viewmodel.BidOverviewViewModel
import com.example.bid.overview.viewmodel.BidOverviewViewState
import com.example.foundation.navigation.NavigationManager
import kotlinx.coroutines.flow.Flow

@Composable
fun BidOverviewDestination(
    viewModel: BidOverviewViewModel,
    viewState: BidOverviewViewState,
    navEffect: Flow<BidOverviewNavEffect>,
    navigationManager: NavigationManager,
) {
    fun onUserAction(): (userIntent: BidOverviewUserIntent) -> Unit = {
        viewModel.performAction(it)
    }

    fun handleEffect(effect: BidOverviewNavEffect) {
        when (effect) {
            is BidOverviewNavEffect.NavigateToDetail -> {

            }
        }
    }

    when (viewState) {
        is BidOverviewViewState.InitialView -> {
            BidOverviewInitialLoading(
                userIntent = onUserAction(),
            )
        }
        is BidOverviewViewState.DataLoaded -> {
            BidOverviewDataLoaded(
                viewState = viewState,
                userIntent = onUserAction(),
            )
        }
    }

    LaunchedEffect(Unit) {
        navEffect.collect {
            handleEffect(it)
        }
    }
}

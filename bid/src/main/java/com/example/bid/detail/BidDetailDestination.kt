package com.example.bid.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.bid.detail.view.BidDetailDataLoaded
import com.example.bid.detail.view.screen.BidDetailInitialLoading
import com.example.bid.detail.viewmodel.BidDetailNavEffect
import com.example.bid.detail.viewmodel.BidDetailUserIntent
import com.example.bid.detail.viewmodel.BidDetailViewModel
import com.example.bid.detail.viewmodel.BidDetailViewState
import com.example.foundation.navigation.NavigationManager
import kotlinx.coroutines.flow.Flow

@Composable
fun BidDetailDestination(
    viewModel: BidDetailViewModel,
    viewState: BidDetailViewState,
    navEffect: Flow<BidDetailNavEffect>,
    navigationManager: NavigationManager,
    collectableId: Int,
) {
    fun onUserAction(): (BidDetailUserIntent) -> Unit = {
        viewModel.handleIntent(it)
    }

    fun handleEffect(effect: BidDetailNavEffect) {

    }

    when (viewState) {
        is BidDetailViewState.InitialView -> {
            BidDetailInitialLoading(
                collectableId = collectableId,
                userIntent = onUserAction(),
            )
        }

        is BidDetailViewState.DataLoaded -> {
            BidDetailDataLoaded(
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
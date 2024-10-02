package com.example.bid.detail

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    fun onUserAction(): (BidDetailUserIntent) -> Unit = {
        viewModel.handleIntent(it)
    }

    fun handleEffect(effect: BidDetailNavEffect) {
        when (effect) {
            BidDetailNavEffect.NavigateBack -> {
                navigationManager.popBackStack()
            }

            is BidDetailNavEffect.ShowToast -> {
                Toast.makeText(context, effect.toastMessage, Toast.LENGTH_LONG).show()
            }
        }
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
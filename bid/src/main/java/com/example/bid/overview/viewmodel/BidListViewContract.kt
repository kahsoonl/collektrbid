package com.example.bid.overview.viewmodel

import com.example.foundation.mvicore.ui.NavEffect
import com.example.foundation.mvicore.ui.UserIntent
import com.example.foundation.mvicore.ui.ViewState

data class ViewState(
    val bidOverviewViewState: BidOverviewViewState
): ViewState

sealed class BidOverviewViewState {
    data object InitialView: BidOverviewViewState()
    data object DataLoaded: BidOverviewViewState()
}

sealed class BidOverviewUserIntent : UserIntent {

}

sealed class BidOverviewNavEffect : NavEffect {
    data class NavigateToDetail(val collectableId: Int) : BidOverviewNavEffect()
}
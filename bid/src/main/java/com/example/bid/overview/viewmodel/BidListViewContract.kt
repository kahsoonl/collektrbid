package com.example.bid.overview.viewmodel

import com.example.bid.overview.domain.model.CollectableModel
import com.example.foundation.mvicore.ui.NavEffect
import com.example.foundation.mvicore.ui.UserIntent
import com.example.foundation.mvicore.ui.ViewState

data class ViewState(
    val bidOverviewViewState: BidOverviewViewState
): ViewState

sealed class BidOverviewViewState {
    data object InitialView: BidOverviewViewState()
    data class DataLoaded(
        val collectableList: List<CollectableModel>
    ) : BidOverviewViewState()
}

sealed class BidOverviewUserIntent : UserIntent {
    data object FetchCollectableData : BidOverviewUserIntent()
    data class CollectableOnClick(val collectableId: Int) : BidOverviewUserIntent()
}

sealed class BidOverviewNavEffect : NavEffect {
    data class NavigateToDetail(val collectableId: Int) : BidOverviewNavEffect()
}
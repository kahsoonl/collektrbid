package com.example.bid.detail.viewmodel

import com.example.bid.detail.domain.model.ChatModel
import com.example.bid.overview.domain.model.CollectableModel
import com.example.foundation.mvicore.ui.NavEffect
import com.example.foundation.mvicore.ui.UserIntent
import com.example.foundation.mvicore.ui.ViewState

data class ViewState(
    val bidDetailViewState: BidDetailViewState
) : ViewState

sealed class BidDetailViewState {
    data object InitialView : BidDetailViewState()
    data class DataLoaded(
        val collectableModel: CollectableModel,
        val chatList: List<ChatModel>,
    ) : BidDetailViewState()
}

sealed class BidDetailUserIntent : UserIntent {
    data class FetchDetailData(val collectableId: Int) : BidDetailUserIntent()
    data object Bid : BidDetailUserIntent()
}

sealed class BidDetailNavEffect : NavEffect {

}
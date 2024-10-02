package com.example.bid.detail.viewmodel

import com.example.bid.detail.domain.model.ChatModel
import com.example.bid.detail.domain.model.CustomBidModel
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
        val customBidInput: CustomBidModel,
    ) : BidDetailViewState()
}

sealed class BidDetailUserIntent : UserIntent {
    data class FetchDetailData(val collectableId: Int) : BidDetailUserIntent()
    data class Bid(val bidAmount: Double, val collectableId: Int) : BidDetailUserIntent()
    data class CustomBidInput(val customBidInput: String) : BidDetailUserIntent()
    data object OnBackPress : BidDetailUserIntent()
}

sealed class BidDetailNavEffect : NavEffect {
    data object NavigateBack : BidDetailNavEffect()
    data class ShowToast(val toastMessage: String) : BidDetailNavEffect()
}
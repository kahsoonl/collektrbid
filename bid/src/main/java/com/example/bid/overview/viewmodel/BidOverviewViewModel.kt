package com.example.bid.overview.viewmodel

import com.example.foundation.mvicore.ui.MviViewModel
import javax.inject.Inject

class BidOverviewViewModel @Inject constructor(

): MviViewModel<BidOverviewUserIntent, ViewState, BidOverviewNavEffect>() {
    override fun createInitialState(): ViewState = ViewState(
        bidOverviewViewState = BidOverviewViewState.InitialView
    )

    override fun handleIntent(intent: BidOverviewUserIntent) {

    }

}
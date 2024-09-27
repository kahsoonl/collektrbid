package com.example.bid.overview.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.bid.overview.data.BidOverviewUseCase
import com.example.foundation.mvicore.ui.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BidOverviewViewModel @Inject constructor(
    private val bidOverviewUseCase: BidOverviewUseCase,
): MviViewModel<BidOverviewUserIntent, ViewState, BidOverviewNavEffect>() {
    override fun createInitialState(): ViewState = ViewState(
        bidOverviewViewState = BidOverviewViewState.InitialView
    )

    override fun handleIntent(intent: BidOverviewUserIntent) {
        viewModelScope.launch {
            when (intent) {
                is BidOverviewUserIntent.FetchCollectableData -> {
                    fetchCollectableAndEmit()
                }
            }
        }
    }

    private suspend fun fetchCollectableAndEmit() {
        bidOverviewUseCase.getCollectableList().collect { collectableList ->
            emitViewState {
                copy(
                    bidOverviewViewState = BidOverviewViewState.DataLoaded(
                        collectableList = collectableList,
                    )
                )
            }
        }
    }
}
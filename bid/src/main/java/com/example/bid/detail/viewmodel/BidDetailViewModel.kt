package com.example.bid.detail.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.bid.detail.domain.BidDetailUseCase
import com.example.foundation.mvicore.ui.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BidDetailViewModel @Inject constructor(
    private val bidDetailUseCase: BidDetailUseCase,
) : MviViewModel<BidDetailUserIntent, ViewState, BidDetailNavEffect>() {
    override fun createInitialState(): ViewState = ViewState(
        bidDetailViewState = BidDetailViewState.InitialView
    )

    override fun handleIntent(intent: BidDetailUserIntent) {
        viewModelScope.launch {
            when (intent) {
                is BidDetailUserIntent.FetchDetailData -> {
                    fetchDetailData(collectableId = intent.collectableId)
                }
            }
        }
    }

    private suspend fun fetchDetailData(collectableId: Int) {
        bidDetailUseCase.fetchCollectableDataFromLocal(collectableId).collect { collectableModel ->
            emitViewState {
                copy(
                    bidDetailViewState = BidDetailViewState.DataLoaded(
                        collectableModel = collectableModel,
                    )
                )
            }
        }
    }
}
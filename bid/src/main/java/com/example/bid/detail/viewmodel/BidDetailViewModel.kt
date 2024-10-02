package com.example.bid.detail.viewmodel

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewModelScope
import com.example.bid.detail.domain.BidDetailUseCase
import com.example.bid.detail.domain.model.ChatModel
import com.example.bid.detail.domain.model.CustomBidModel
import com.example.foundation.mvicore.ui.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

                is BidDetailUserIntent.Bid -> {
                    insertBid(
                        bidAmount = intent.bidAmount,
                        collectableId = intent.collectableId,
                    )
                }

                is BidDetailUserIntent.CustomBidInput -> {
                    validateBidInput(
                        input = intent.customBidInput
                    )
                }

                is BidDetailUserIntent.OnBackPress -> {
                    sendNavEffect {
                        BidDetailNavEffect.NavigateBack
                    }
                }
            }
        }
    }

    private fun getCurrentStateAsLoaded() =
        currentState.bidDetailViewState as BidDetailViewState.DataLoaded

    private suspend fun fetchDetailData(collectableId: Int) {
        bidDetailUseCase.fetchCollectableDataFromLocal(collectableId).collect { collectableModel ->
            emitViewState {
                copy(
                    bidDetailViewState = BidDetailViewState.DataLoaded(
                        collectableModel = collectableModel,
                        chatList = ChatModel.dummyData,
                        customBidInput = CustomBidModel.emptyValue,
                    )
                )
            }
        }
    }

    private suspend fun insertBid(
        bidAmount: Double,
        collectableId: Int,
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            bidDetailUseCase.insertBidToLocal(
                bidAmount = bidAmount,
                collectableId = collectableId,
            ).collect { returnedId ->
                // Signifies insert success
                if (returnedId > 0) {
                    sendNavEffect {
                        BidDetailNavEffect.ShowToast("Bid inserted successfully!")
                    }
                } else {
                    sendNavEffect {
                        BidDetailNavEffect.ShowToast("Something went wrong inserting bid, please try again!")
                    }
                }
            }
        }
    }

    private fun validateBidInput(input: String) {
        if (input.isDigitsOnly() && input.count() <= 10) {
            val currentCollectable = getCurrentStateAsLoaded().collectableModel

            emitViewState {
                copy(
                    bidDetailViewState = getCurrentStateAsLoaded().copy(
                        customBidInput = CustomBidModel(
                            customBidInput = input,
                            showError = if (input.isNotEmpty()) {
                                input.toDouble() < currentCollectable.collectableBids.last().bidAmount
                            } else true
                        )
                    )
                )
            }
        }
    }
}
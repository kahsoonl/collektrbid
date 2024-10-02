package com.example.bid.detail.domain

import com.example.bid.overview.domain.model.CollectableModel
import kotlinx.coroutines.flow.Flow

interface BidDetailUseCase {
    fun fetchCollectableDataFromLocal(collectableId: Int): Flow<CollectableModel>
    fun insertBidToLocal(bidAmount: Double, collectableId: Int): Flow<Long>
}
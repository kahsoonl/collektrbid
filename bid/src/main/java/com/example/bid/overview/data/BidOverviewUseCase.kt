package com.example.bid.overview.data

import com.example.bid.overview.domain.model.CollectableModel
import kotlinx.coroutines.flow.Flow

interface BidOverviewUseCase {
    fun getCollectableList(): Flow<List<CollectableModel>>
}
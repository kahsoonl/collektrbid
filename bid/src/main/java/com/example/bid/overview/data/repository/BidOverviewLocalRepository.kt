package com.example.bid.overview.data.repository

import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow

interface BidOverviewLocalRepository {
    fun getCollectableFromLocal(): Flow<List<CollectableWithRelation>>
}
package com.example.bid.detail.data.repository

import com.example.foundation.database.entity.bid.BidEntity
import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow

interface BidDetailLocalRepository {
    fun fetchCollectableDataFromLocal(collectableId: Int): Flow<CollectableWithRelation>
    fun insertBidToLocal(bidEntity: BidEntity): Flow<Long>
}
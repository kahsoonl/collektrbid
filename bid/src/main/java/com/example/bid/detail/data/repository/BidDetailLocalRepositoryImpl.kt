package com.example.bid.detail.data.repository

import com.example.foundation.database.dao.bid.BidDao
import com.example.foundation.database.dao.collectable.CollectableDao
import com.example.foundation.database.entity.bid.BidEntity
import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BidDetailLocalRepositoryImpl @Inject constructor(
    private val collectableDao: CollectableDao,
    private val bidDao: BidDao,
) : BidDetailLocalRepository {
    override fun fetchCollectableDataFromLocal(collectableId: Int): Flow<CollectableWithRelation> {
        return collectableDao.getCollectableByID(collectableId = collectableId)
    }

    override fun insertBidToLocal(bidEntity: BidEntity): Flow<Long> {
        return flow { emit(bidDao.insertBid(bidEntity)) }
    }
}
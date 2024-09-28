package com.example.bid.detail.data.repository

import com.example.foundation.database.dao.collectable.CollectableDao
import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BidDetailLocalRepositoryImpl @Inject constructor(
    private val collectableDao: CollectableDao,
) : BidDetailLocalRepository {
    override fun fetchCollectableDataFromLocal(collectableId: Int): Flow<CollectableWithRelation> {
        return collectableDao.getCollectableByID(collectableId = collectableId)
    }
}
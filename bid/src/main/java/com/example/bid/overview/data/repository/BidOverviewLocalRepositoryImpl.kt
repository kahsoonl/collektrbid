package com.example.bid.overview.data.repository

import com.example.foundation.database.dao.collectable.CollectableDao
import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BidOverviewLocalRepositoryImpl @Inject constructor(
    private val collectableDao: CollectableDao,
) : BidOverviewLocalRepository {
    override fun getCollectableFromLocal(): Flow<List<CollectableWithRelation>> {
        return collectableDao.getAllCollectables()
    }
}
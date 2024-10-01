package com.example.foundation.database.contract

import com.example.foundation.database.dao.bid.BidDao
import com.example.foundation.database.dao.collectable.CollectableDao
import com.example.foundation.database.entity.bid.BidEntity
import com.example.foundation.database.entity.collectable.CollectableEntity
import javax.inject.Inject

class InitDummyDataContractImpl @Inject constructor(
    private val bidDao: BidDao,
    private val collectableDao: CollectableDao,
) : InitDummyDataContract {

    override fun insertDummyDataToLocalDb() {
        val collectableIds = collectableDao.insertCollectables(
            listOf(
                CollectableEntity(
                    collectableName = "Nike Shoes",
                    collectableDescription = "The shoe is one of a kind, is in immaculate condition and ready for new owner",
                ),
                CollectableEntity(
                    collectableName = "Summoned Skull",
                    collectableDescription = "The shoe is one of a kind, is in immaculate condition and ready for new owner",
                ),
                CollectableEntity(
                    collectableName = "Blue Eyes White Dragon",
                    collectableDescription = "The shoe is one of a kind, is in immaculate condition and ready for new owner",
                ),
                CollectableEntity(
                    collectableName = "Charizard First Edition",
                    collectableDescription = "The shoe is one of a kind, is in immaculate condition and ready for new owner",
                ),
                CollectableEntity(
                    collectableName = "Deadpool and Wolverine Funkopop",
                    collectableDescription = "The shoe is one of a kind, is in immaculate condition and ready for new owner",
                ),
            )
        )
        collectableIds.forEach { collectableId ->

            val bidDummyData = listOf(
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "DarkMagician33 $collectableId",
                    bidAmount = 50 + collectableId.toInt(),
                ),
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "NecessityNotLuxury $collectableId",
                    bidAmount = 60 + collectableId.toInt(),
                ),
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "smallSpoon2 $collectableId",
                    bidAmount = 70 + collectableId.toInt(),
                ),
            )

            bidDao.insertBids(bidDummyData)
        }
    }
}
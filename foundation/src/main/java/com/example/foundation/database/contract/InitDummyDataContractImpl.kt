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
                    collectableDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ),
                CollectableEntity(
                    collectableName = "Summoned Skull",
                    collectableDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ),
                CollectableEntity(
                    collectableName = "Blue Eyes White Dragon",
                    collectableDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ),
                CollectableEntity(
                    collectableName = "Charizard First Edition",
                    collectableDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ),
                CollectableEntity(
                    collectableName = "Deadpool and Wolverine Funkopop",
                    collectableDescription = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                ),
            )
        )
        collectableIds.forEach { collectableId ->
            val bidDummyData = listOf(
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "DarkMagician33",
                    bidAmount = 50.00,
                ),
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "NecessityNotLuxury",
                    bidAmount = 60.00,
                ),
                BidEntity(
                    collectableId = collectableId.toInt(),
                    userName = "smallSpoon2",
                    bidAmount = 70.00,
                ),
            )

            bidDao.insertBids(bidDummyData)
        }
    }
}
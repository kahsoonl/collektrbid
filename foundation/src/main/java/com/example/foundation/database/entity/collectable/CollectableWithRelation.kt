package com.example.foundation.database.entity.collectable

import androidx.room.Embedded
import androidx.room.Relation
import com.example.foundation.database.entity.bid.BidEntity
import com.example.foundation.database.entity.bid.BidWithRelation

data class CollectableWithRelation(
    @Embedded
    val collectable: CollectableEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "collectable_id",
        entity = BidEntity::class,
    )
    val bids: List<BidWithRelation> = emptyList(),
)
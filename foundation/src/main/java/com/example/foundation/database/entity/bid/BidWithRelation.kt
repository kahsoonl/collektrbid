package com.example.foundation.database.entity.bid

import androidx.room.Embedded
import androidx.room.Relation
import com.example.foundation.database.entity.user.UserEntity

class BidWithRelation (
    @Embedded
    val bid : BidEntity,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "id",
        entity = UserEntity::class,
    )
    val user: UserEntity = UserEntity.emptyValue,
)
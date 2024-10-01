package com.example.foundation.database.entity.bid

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foundation.database.BID_TABLE
import com.example.foundation.interaction.util.emptyValue

@Entity(tableName = BID_TABLE)
class BidEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val bidId: Int = Int.emptyValue(),

    @ColumnInfo(name = "collectable_id")
    val collectableId: Int = Int.emptyValue(),

    @ColumnInfo(name = "user_name")
    val userName: String = String.emptyValue(),

    @ColumnInfo(name = "bid_amount")
    val bidAmount: Int = Int.emptyValue(),
)
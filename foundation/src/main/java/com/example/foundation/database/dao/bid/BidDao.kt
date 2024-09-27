package com.example.foundation.database.dao.bid

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.foundation.database.entity.bid.BidEntity

@Dao
abstract class BidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBids(bids: List<BidEntity>)
}
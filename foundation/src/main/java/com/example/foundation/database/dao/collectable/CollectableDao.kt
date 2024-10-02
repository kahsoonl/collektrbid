package com.example.foundation.database.dao.collectable

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.foundation.database.COLLECTABLE_TABLE
import com.example.foundation.database.entity.collectable.CollectableEntity
import com.example.foundation.database.entity.collectable.CollectableWithRelation
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CollectableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCollectables(collectables: List<CollectableEntity>): List<Long>

    @Transaction
    @Query("SELECT * FROM $COLLECTABLE_TABLE")
    abstract fun getAllCollectables(): Flow<List<CollectableWithRelation>>

    @Transaction
    @Query("SELECT * FROM $COLLECTABLE_TABLE WHERE id = :collectableId")
    abstract fun getCollectableByID(collectableId: Int): Flow<CollectableWithRelation>
}
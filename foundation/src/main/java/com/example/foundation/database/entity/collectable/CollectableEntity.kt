package com.example.foundation.database.entity.collectable

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foundation.database.COLLECTABLE_TABLE
import com.example.foundation.interaction.util.emptyValue

@Entity(tableName = COLLECTABLE_TABLE)
class CollectableEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val collectableId: Int = Int.emptyValue(),

    @ColumnInfo(name = "collectable_name")
    val collectableName: String = String.emptyValue(),

    @ColumnInfo(name = "collectable_desc")
    val collectableDescription: String = String.emptyValue(),
)
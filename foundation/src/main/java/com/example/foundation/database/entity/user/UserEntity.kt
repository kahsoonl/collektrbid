package com.example.foundation.database.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foundation.database.USER_TABLE
import com.example.foundation.interaction.util.emptyValue

@Entity(tableName = USER_TABLE)
class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val userId: Int = Int.emptyValue(),

    @ColumnInfo(name = "user_name")
    val userName: String = String.emptyValue(),
) {
    companion object {
        val emptyValue = UserEntity()
    }
}
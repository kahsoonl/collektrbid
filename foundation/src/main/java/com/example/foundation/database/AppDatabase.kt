package com.example.foundation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foundation.database.dao.bid.BidDao
import com.example.foundation.database.dao.collectable.CollectableDao
import com.example.foundation.database.entity.bid.BidEntity
import com.example.foundation.database.entity.collectable.CollectableEntity

@Database(
    entities = [
        BidEntity::class,
        CollectableEntity::class,
    ],
    version = 1,
    exportSchema = false,
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getBidDao(): BidDao
    abstract fun getCollectableDao(): CollectableDao

    companion object {
        private const val DB_NAME = "App-Database.db"

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME,
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
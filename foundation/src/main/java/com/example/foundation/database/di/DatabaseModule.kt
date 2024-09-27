package com.example.foundation.database.di

import android.content.Context
import com.example.foundation.database.AppDatabase
import com.example.foundation.database.dao.bid.BidDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideBidDao(database: AppDatabase): BidDao {
        return database.getBidDao()
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase(appContext)
    }
}
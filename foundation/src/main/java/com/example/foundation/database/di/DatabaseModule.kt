package com.example.foundation.database.di

import android.content.Context
import com.example.foundation.database.AppDatabase
import com.example.foundation.database.contract.InitDummyDataContract
import com.example.foundation.database.contract.InitDummyDataContractImpl
import com.example.foundation.database.dao.bid.BidDao
import com.example.foundation.database.dao.collectable.CollectableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideBidDao(database: AppDatabase): BidDao = database.getBidDao()

    @Provides
    fun provideCollectableDao(database: AppDatabase): CollectableDao = database.getCollectableDao()

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase(appContext)
    }

    @Singleton
    @Provides
    fun provideInitDummyDataContract(
        bidDao: BidDao,
        collectableDao: CollectableDao,
    ): InitDummyDataContract = InitDummyDataContractImpl(bidDao, collectableDao)
}
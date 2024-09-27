package com.example.bid.overview.di

import com.example.bid.overview.data.BidOverviewUseCase
import com.example.bid.overview.data.BidOverviewUseCaseImpl
import com.example.bid.overview.data.repository.BidOverviewLocalRepository
import com.example.bid.overview.data.repository.BidOverviewLocalRepositoryImpl
import com.example.foundation.database.dao.collectable.CollectableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BidOverviewModule {

    @Provides
    fun provideBidOverviewLocalRepository(
        collectableDao: CollectableDao,
    ): BidOverviewLocalRepository = BidOverviewLocalRepositoryImpl(collectableDao)

    @Provides
    fun provideBidUseCase(
        bidOverviewLocalRepository: BidOverviewLocalRepository,
    ): BidOverviewUseCase = BidOverviewUseCaseImpl(bidOverviewLocalRepository)
}
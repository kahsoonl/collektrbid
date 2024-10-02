package com.example.bid.detail.di

import com.example.bid.detail.data.repository.BidDetailLocalRepository
import com.example.bid.detail.data.repository.BidDetailLocalRepositoryImpl
import com.example.bid.detail.domain.BidDetailUseCase
import com.example.bid.detail.domain.BidDetailUseCaseImpl
import com.example.foundation.database.dao.bid.BidDao
import com.example.foundation.database.dao.collectable.CollectableDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BidDetailModule {
    @Singleton
    @Provides
    fun provideBidDetailLocalRepository(
        collectableDao: CollectableDao,
        bidDao: BidDao
    ): BidDetailLocalRepository =
        BidDetailLocalRepositoryImpl(collectableDao, bidDao)

    @Singleton
    @Provides
    fun provideBidDetailUseCase(bidDetailLocalRepository: BidDetailLocalRepository): BidDetailUseCase =
        BidDetailUseCaseImpl(bidDetailLocalRepository)

}
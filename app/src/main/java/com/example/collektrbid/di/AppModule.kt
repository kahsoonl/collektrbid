package com.example.collektrbid.di

import com.example.collektrbid.domain.usecase.AppUseCase
import com.example.collektrbid.domain.usecase.AppUseCaseImpl
import com.example.foundation.database.contract.InitDummyDataContract
import com.example.foundation.navigation.NavigationManager
import com.example.foundation.navigation.NavigationManagerImpl
import com.example.foundation.securestorage.contract.ModifyFirstLaunchContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideNavigationManager(): NavigationManager {
        return NavigationManagerImpl(CoroutineScope(Dispatchers.Main))
    }

    @Singleton
    @Provides
    fun provideAppUseCase(
        initDummyDataContract: InitDummyDataContract,
        modifyFirstLaunchContract: ModifyFirstLaunchContract,
    ): AppUseCase = AppUseCaseImpl(initDummyDataContract, modifyFirstLaunchContract)
}
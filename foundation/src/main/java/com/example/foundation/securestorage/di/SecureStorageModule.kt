package com.example.foundation.securestorage.di

import android.content.Context
import com.example.foundation.securestorage.contract.ModifyFirstLaunchContract
import com.example.foundation.securestorage.contract.ModifyFirstLaunchContractImpl
import com.example.foundation.securestorage.contract.ReadFirstLaunchContract
import com.example.foundation.securestorage.contract.ReadFirstLaunchContractImpl
import com.example.foundation.securestorage.datastore.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecureStorageModule {

    @Singleton
    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context)

    @Singleton
    @Provides
    fun provideModifyFirstLaunchContract(dataStoreManager: DataStoreManager): ModifyFirstLaunchContract =
        ModifyFirstLaunchContractImpl(dataStoreManager)

    @Singleton
    @Provides
    fun provideReadFirstLaunchContract(dataStoreManager: DataStoreManager): ReadFirstLaunchContract =
        ReadFirstLaunchContractImpl(dataStoreManager)
}

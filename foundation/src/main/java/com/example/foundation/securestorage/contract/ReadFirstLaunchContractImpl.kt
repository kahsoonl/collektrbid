package com.example.foundation.securestorage.contract

import com.example.foundation.securestorage.datastore.DataStoreManager
import com.example.foundation.securestorage.datastore.keys.PreferenceKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReadFirstLaunchContractImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ReadFirstLaunchContract {
    override fun getIsFirstLaunch(): Flow<Boolean?> {
        return dataStoreManager.readBoolean(PreferenceKeys.IS_FRESH_INSTALL).map { isFirstLaunch ->
            // If it's null return true meaning its a fresh install
            isFirstLaunch ?: true
        }.flowOn(Dispatchers.IO)
    }
}
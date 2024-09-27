package com.example.foundation.securestorage.contract

import com.example.foundation.securestorage.datastore.DataStoreManager
import com.example.foundation.securestorage.datastore.keys.PreferenceKeys
import javax.inject.Inject

class ModifyFirstLaunchContractImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager,
) : ModifyFirstLaunchContract {
    override suspend fun updateIsFirstLaunch() {
        dataStoreManager.storeValue(PreferenceKeys.IS_FRESH_INSTALL, false)
    }
}
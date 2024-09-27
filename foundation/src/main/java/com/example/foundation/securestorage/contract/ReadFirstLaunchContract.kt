package com.example.foundation.securestorage.contract

import kotlinx.coroutines.flow.Flow

interface ReadFirstLaunchContract {
    fun getIsFirstLaunch(): Flow<Boolean?>
}
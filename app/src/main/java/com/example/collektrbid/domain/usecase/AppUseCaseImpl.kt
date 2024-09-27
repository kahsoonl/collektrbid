package com.example.collektrbid.domain.usecase

import com.example.foundation.database.contract.InitDummyDataContract
import com.example.foundation.securestorage.contract.ModifyFirstLaunchContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppUseCaseImpl @Inject constructor(
    private val initDummyDataContract: InitDummyDataContract,
    private val modifyFirstLaunchContract: ModifyFirstLaunchContract,
) : AppUseCase {
    override fun initAndInsertDummyData() {
        CoroutineScope(Dispatchers.IO).launch {
            initDummyDataContract.insertDummyDataToLocalDb()
            modifyFirstLaunchContract.updateIsFirstLaunch()
        }
    }
}
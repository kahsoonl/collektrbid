package com.example.collektrbid

import android.app.Application
import com.example.collektrbid.domain.usecase.AppUseCase
import com.example.foundation.securestorage.contract.ReadFirstLaunchContract
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var appUseCase: Lazy<AppUseCase>

    @Inject
    lateinit var readFirstLaunchContract: ReadFirstLaunchContract

    override fun onCreate() {
        super.onCreate()
        initData()
    }

    private fun initData() {
        CoroutineScope(Dispatchers.IO).launch {
            readFirstLaunchContract.getIsFirstLaunch().collect {
                if (it != null && it) {
                    appUseCase.get().initAndInsertDummyData()
                }
            }
        }
    }
}
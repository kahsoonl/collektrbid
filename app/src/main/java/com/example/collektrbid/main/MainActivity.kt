package com.example.collektrbid.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.collektrbid.util.LocalNavGraphViewModelStoreOwner
import com.example.collektrbid.util.rememberViewModelStoreOwner
import com.example.foundation.design.theme.AppTheme
import com.example.foundation.navigation.NavigationManager
import com.example.foundation.navigation.initialNavCommand
import com.example.foundation.navigation.navigateToDestination
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavHostController

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppThemeContent()
        }
        observeNavigationCommands()
    }

    @Composable
    fun AppThemeContent() {
        AppTheme {
            val padding = remember {
                mutableStateOf(PaddingValues())
            }
            val rootRoute = remember {
                mutableStateOf(initialNavCommand.route)
            }
            navController = rememberNavController()
            Scaffold(
                content = { paddingValues ->
                    padding.value = paddingValues
                    AppNavigationGraph(
                        startDestinationRoute = rootRoute,
                    )
                }
            )
        }
    }

    @Composable
    private fun AppNavigationGraph(
        startDestinationRoute: MutableState<String>,
    ) {
        val sharedVMStoreOwner = rememberViewModelStoreOwner()
        CompositionLocalProvider(
            LocalNavGraphViewModelStoreOwner provides sharedVMStoreOwner
        ) {
            AppNavGraph(
                startDestination = startDestinationRoute,
                navController = navController,
                navigationManager = navigationManager,
            )
        }
    }

    private fun observeNavigationCommands() {
        lifecycleScope.launch {
            navigationManager.navCommand
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { navObject ->
                    navigateToDestination(
                        navObject = navObject,
                        navController = navController,
                    )
                }
        }
    }
}
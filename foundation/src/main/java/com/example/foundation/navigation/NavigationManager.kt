package com.example.foundation.navigation

import kotlinx.coroutines.flow.SharedFlow

/**
 * This is the interface for the navigation manager.
 */
interface NavigationManager {
    val navCommand: SharedFlow<NavigationCommand>
    fun navigateTo(command: NavigationCommand, arguments: Any? = null)
    fun popBackStack()
}

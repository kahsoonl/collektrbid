package com.example.foundation.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

data class NavCommandWithArgs(
    val command: NavigationCommand = NavigationCommand.None,
    val arguments: Any? = null,
    val overrideBackCommand: NavigationCommand? = null,
)

class NavigationManagerImpl(private val scope: CoroutineScope) : NavigationManager {

    private val _navCommand = MutableSharedFlow<NavCommandWithArgs>()

    override var navCommand: SharedFlow<NavCommandWithArgs> = _navCommand.asSharedFlow()

    override fun navigateTo(command: NavigationCommand, arguments: Any?) {
        scope.launch {
            _navCommand.emit(
                NavCommandWithArgs(
                    command = command,
                    arguments = arguments,
                ),
            )
        }
    }

    override fun popBackStack() {
        scope.launch {
            _navCommand.emit(
                NavCommandWithArgs(
                    command = NavigationCommand.PopBackStack,
                ),
            )
        }
    }
}

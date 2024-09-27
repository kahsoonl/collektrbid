package com.example.foundation.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class NavigationManagerImpl(private val scope: CoroutineScope) : NavigationManager {

    private val _navCommand = MutableSharedFlow<NavigationCommand>()

    override var navCommand: SharedFlow<NavigationCommand> = _navCommand.asSharedFlow()

    override fun navigateTo(command: NavigationCommand, arguments: Any?) {
        scope.launch {
            _navCommand.emit(
                command,
            )
        }
    }

    override fun popBackStack() {
        scope.launch {
            _navCommand.emit(
                NavigationCommand.PopBackStack,
            )
        }
    }
}

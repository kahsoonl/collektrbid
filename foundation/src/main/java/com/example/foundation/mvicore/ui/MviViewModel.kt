package com.example.foundation.mvicore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface ViewState

interface UserIntent

interface NavEffect

abstract class MviViewModel<Intent : UserIntent, State : ViewState, Effect : NavEffect> :
    ViewModel() {

    // Create Initial State of View.
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    // Get Current State.
    val currentState: State
        get() = viewState.value

    private val _viewState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val viewState
        get() = _viewState.asStateFlow()

    private val _intent: MutableSharedFlow<Intent> = MutableSharedFlow()
    val intent
        get() = _intent.asSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect
        get() = _effect.receiveAsFlow()

    init {
        subscribeIntent()
    }

    /**
     * Start listening to Intent.
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }

    /**
     * Handle each Intent.
     */
    abstract fun handleIntent(intent: Intent)

    /**
     * Set new UserIntent.
     */
    fun performAction(intent: Intent) {
        val newUserIntent = intent
        viewModelScope.launch { _intent.emit(newUserIntent) }
    }

    /**
     * Emit new ViewState.
     */
    protected fun emitViewState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _viewState.value = newState
    }

    /**
     * Set new NavEffect.
     */
    protected fun sendNavEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}

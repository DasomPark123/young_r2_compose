package com.young.r2.compose.core.common.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

interface ViewState

abstract class BaseViewModel<UiState: ViewState>: ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    abstract fun setInitialState(): UiState

    private lateinit var initialState: UiState

    private val _uiState: MutableState<UiState> by lazy { mutableStateOf(initialState) }

    val uiState: State<UiState> by lazy { _uiState }

    /**
     * 상태 변경 메서드
     * setState { copy(변수명 = value) } 형태로 사용해야 한다.
     */
    fun setState(reducer: UiState.() -> UiState) {
        val newState = uiState.value.reducer()
        _uiState.value = newState
    }

    /**
     * 하위 ViewModel 의 init 시점에 호출해 주어야 하위 ViewModel 이 생성된 이후에 초기화 되는 것을 보장할 수 있다.
     */
    fun initializeState() {
        initialState = setInitialState()
        _uiState.value = initialState
    }
}
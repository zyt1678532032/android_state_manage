package com.example.state_manage_example

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private var _counter: MutableState<Int> = mutableIntStateOf(0)
    val counter: State<Int> = _counter

    private var _counterFlow = MutableStateFlow(0)
    val counterFlow: StateFlow<Int> = _counterFlow


    fun increase() {
        _counter.value = _counter.value + 1
    }

    fun increaseByFlow() {
        _counterFlow.update {
            it + 1
        }
    }


}
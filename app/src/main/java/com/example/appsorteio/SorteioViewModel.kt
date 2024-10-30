package com.example.appsorteio

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SorteioViewModel : ViewModel() {

    private val repository = SorteioRepository()

    private val _uiState = MutableStateFlow("-")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    fun sortearNumero() {
        val numero = repository.sortearNumero()
        _uiState.update {
            numero.toString()
        }
    }
}

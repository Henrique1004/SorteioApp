package com.example.appsorteio

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SorteioViewModel : ViewModel() {

    private val repository = SorteioRepository()

    private val _numeroSorteado = MutableSharedFlow<Int>()
    val numeroSorteado: SharedFlow<Int> = _numeroSorteado.asSharedFlow()

    suspend fun sortearNumero() {
        val numero = repository.sortearNumero()
        _numeroSorteado.emit(numero)
    }
}

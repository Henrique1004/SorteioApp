package com.example.appsorteio

import kotlin.random.Random

class SorteioRepository {

    fun sortearNumero(): Int {
        return Random.nextInt(1, 1001)
    }
}

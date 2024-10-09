package com.example.appsorteio

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appsorteio.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: SorteioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.numeroSorteado.collect { numero ->
                exibeNumero(numero)
            }
        }

        binding.botao.setOnClickListener {
            lifecycleScope.launch {
                viewModel.sortearNumero()
            }
        }
    }

    private fun exibeNumero(numero: Int) {
        binding.label.text = numero.toString()
    }
}

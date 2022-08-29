package br.com.fiap.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.pokedex.adapters.PokedexAdapter
import br.com.fiap.pokedex.databinding.ActivityPokedexPagerBinding


class PokedexPagerActivity : AppCompatActivity() {

    lateinit var binding: ActivityPokedexPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokedexPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpPokedex.adapter = PokedexAdapter()

    }
}
package br.com.fiap.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.fiap.pokedex.databinding.ActivityMainBinding
import br.com.fiap.pokedex.models.Pokemon
import br.com.fiap.pokedex.services.PokemonConnection
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
         binding.llPokemon.visibility = View.GONE
         binding.pbLoading.visibility = View.GONE
         binding.btSearch.setOnClickListener {
             val number = binding.etNumber.text.toString().toInt()
             getPokemon(number)
         }
    }

    //Chama o Pokemon colocando ele na fila
    fun getPokemon(number: Int) {
        binding.pbLoading.visibility = View.VISIBLE

        PokemonConnection().service.getPokemon(number).enqueue(object : Callback<Pokemon> {

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (!response.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "Falha ao Buscar Pokémon",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                response.body()?.let { pokemon ->
                    configurePokemon(pokemon)
                } ?: run {
                    Toast.makeText(
                        this@MainActivity,
                        "Falha ao Buscar Pokémon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Falha ao Buscar Pokémon", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    //Mostrar o Pokemon
    private fun configurePokemon(pokemon: Pokemon) {
         binding.llPokemon.visibility = View.VISIBLE
         binding.pbLoading.visibility = View.GONE
         binding.tvName.text = pokemon.name
         binding.tvPokeNumber.text = "Nº pokemon: " + pokemon.id.toString()

        var typesText = "Tipo: "
        pokemon.types.forEach{ type ->
            typesText += type.typeDetail.name
            typesText += ", "

        }
         binding.tvTypes.text = typesText.substring(0, typesText.length-2)

        Glide
            .with(this@MainActivity)
            .load(pokemon.sprites.front)
            .into(binding.ivPokemon)

    }

}
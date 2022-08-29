package br.com.fiap.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.pokedex.R
import br.com.fiap.pokedex.models.Pokemon
import br.com.fiap.pokedex.services.PokemonConnection
import br.com.fiap.pokedex.utils.getPokemonColor
import br.com.fiap.pokedex.utils.loadUrl
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokedexAdapter : RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>() {

    class PokedexViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokedex, parent, false)
        return PokedexViewHolder(view)
    }

    //Lista Pokémon
    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {

        PokemonConnection().service.getPokemon(position+1).enqueue(object: Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
               if (!response.isSuccessful) {
                   Toast.makeText( holder.view.context," Falha ao encontrar o Pokémon", Toast.LENGTH_SHORT).show()
                  return
               }
                response.body()?.let { pokemon ->
                configurePokemon(holder.view,pokemon)
                } ?: run {

                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                 Toast.makeText( holder.view.context," Falha ao Buscar o Pokémon", Toast.LENGTH_SHORT).show()
            }
        })


    }
    //Aparecer até 0 150 Pokémon
    override fun getItemCount(): Int {
         return 150
    }

    private fun configurePokemon( view: View,pokemon: Pokemon) {
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvTypes = view.findViewById<TextView>(R.id.tvTypes)
        val ivPokemon = view.findViewById<ImageView>(R.id.ivPokemon)
        tvName.text = "#${pokemon.id} " + pokemon.name.capitalize()

        var typesText = "Tipo: "
        pokemon.types.forEach{ type ->
            typesText += type.typeDetail.name
            typesText += ", "

        }
        //Setando os atributos do Pokémon
        tvTypes.text = typesText.substring(0, typesText.length-2)

        ivPokemon.loadUrl(pokemon.sprites.front)

        Glide
            .with(view.context)
            .load(pokemon.sprites.front)
            .into(ivPokemon)

        val type = pokemon.types[0].typeDetail.name
        val backgroundColor = type.getPokemonColor()
        view.setBackgroundColor(backgroundColor)
    }


}
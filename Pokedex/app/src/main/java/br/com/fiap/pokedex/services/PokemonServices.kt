package br.com.fiap.pokedex.services

import br.com.fiap.pokedex.models.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonInterface {

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") number: Int) : Call<Pokemon>

}

class PokemonConnection{

   private var retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service  = retrofit.create(PokemonInterface::class.java)
}
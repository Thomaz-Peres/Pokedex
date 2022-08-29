package br.com.fiap.pokedex.models

import com.google.gson.annotations.SerializedName

//Boas Práticas: SerializedName para manter a formatação do mapeamento!

data class Pokemon (
    @SerializedName("id")val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("types") val types: List<Type>
        )

  data class Sprites(
     @SerializedName("front_default") val front: String
  )

  data class Type(
      @SerializedName("type") val typeDetail: TypeDetail
  )

  data class TypeDetail(
      @SerializedName("name") val name:String,

  )
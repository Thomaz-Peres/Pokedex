package br.com.fiap.pokedex.utils

import android.graphics.Color
import android.widget.ImageView
import com.bumptech.glide.Glide

fun String.getPokemonColor() : Int {
    return when (this) {
        "normal" -> Color.parseColor("#A8A77A")
        "fire" -> Color.parseColor("#EE8130")
        "water" -> Color.parseColor("#6390F0")
        "electric" -> Color.parseColor("#F7D02C")
        "grass" -> Color.parseColor("#7AC74C")
        "ice" -> Color.parseColor("#96D9D6")
        "fighting" -> Color.parseColor("#C22E28")
        "poison" -> Color.parseColor("#A33EA1")
        "ground" -> Color.parseColor("#E2BF65")
        "flying" -> Color.parseColor("#A98FF3")
        "psychic" -> Color.parseColor("#F95587")
        "bug" -> Color.parseColor("#A6B91A")
        "rock" -> Color.parseColor("#B6A136")
        "ghost" -> Color.parseColor("#735797")
        "dragon" -> Color.parseColor("#6F35FC")
        "dark" -> Color.parseColor("#705746")
        "steel" -> Color.parseColor("#B7B7CE")
        "fairy" -> Color.parseColor("#D685AD")
        else -> Color.parseColor("#EEEEEE")
    }
}

fun ImageView.loadUrl(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .into(this)
}
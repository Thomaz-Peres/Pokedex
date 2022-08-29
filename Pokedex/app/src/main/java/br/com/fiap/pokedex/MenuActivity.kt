package br.com.fiap.pokedex


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.pokedex.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnPokemonsSearch.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnPokemonList.setOnClickListener {
            val intent = Intent(this@MenuActivity, PokedexPagerActivity::class.java)
            startActivity(intent)
        }

        binding.btnSobre.setOnClickListener {
            val intent = Intent(this@MenuActivity, AboutPageActivity::class.java)
            startActivity(intent)
        }

        binding.btnFiap.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiap.com.br/graduacao/tecnologo/jogos-digitais/"))
            startActivity(intent)
        }
    }
}
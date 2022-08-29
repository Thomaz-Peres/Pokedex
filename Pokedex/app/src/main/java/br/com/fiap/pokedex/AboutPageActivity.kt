package br.com.fiap.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.pokedex.databinding.ActivityAboutPageBinding

class AboutPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
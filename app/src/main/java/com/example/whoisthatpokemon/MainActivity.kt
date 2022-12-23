package com.example.whoisthatpokemon

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import androidx.core.widget.addTextChangedListener
import com.example.whoisthatpokemon.data.DataPokemon
import com.example.whoisthatpokemon.data.RandomPokemon
import com.example.whoisthatpokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var lives: Int = 3
    private var score: Int = 0
    private var pokechoosed: String = "Charmander"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        changeTextPokemon()
        binding.btSubmit.setOnClickListener{
            showPokemon()
        }
        binding.btNextPokemon.setOnClickListener {
            nextPokemon()
        }

    }

    private fun chooseRandomPoke() : RandomPokemon {
        return DataPokemon.pokemonList[(1 until DataPokemon.pokemonList.size).random()]
    }

    private fun changeTextPokemon(){
        binding.txtPokeInput.addTextChangedListener {
            binding.txtPokeName.text = it
        }
    }

    private fun showPokemon(){
        with(binding){
            if(txtPokeName.text.toString()==pokechoosed){
                imgPokeFront.visibility = View.GONE
                btSubmit.visibility = View.GONE
                btNextPokemon.visibility = View.VISIBLE
                score += 10
                txtScore.text = score.toString()
            }else{
                Toast.makeText(txtPokeInput.context, "NOMBRE INCORRECTO", Toast.LENGTH_SHORT).show()
                lives -= 1
                txtLive.text = lives.toString()
                if(lives == 0) run {
                    val builder = AlertDialog.Builder(txtPokeInput.context)
                    builder.setTitle("GAME OVER")
                    builder.setMessage("SCORE: $score\nDo you want to try again?")
                    builder.setIcon(android.R.drawable.ic_dialog_alert)

                    builder.setPositiveButton("YES") { dialogInterface, which ->
                        lives = 3
                        score = 0
                        txtScore.text = score.toString()
                        txtLive.text = lives.toString()
                        txtPokeInput.text.clear()
                        nextPokemon()
                    }
                    builder.setNegativeButton("EXIT") { dialogInterface, which ->
                        finish()
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.setCancelable(false)
                    alertDialog.show()

                }
            }
        }
    }

    private fun nextPokemon(){
        with(binding){
            choosePhotos()
            imgPokeFront.visibility = View.VISIBLE
            btSubmit.visibility = View.VISIBLE
            btNextPokemon.visibility = View.GONE
            txtPokeInput.text.clear()
        }
    }


    private fun choosePhotos() : Any? {
        var x = when(chooseRandomPoke().id) {
            1 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charmander)
                binding.imgPokeBack.setImageResource(R.drawable.charmander)
                pokechoosed = DataPokemon.pokemonList[1].pokemonName
                println(pokechoosed)
            }
            2 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charmeleon)
                binding.imgPokeBack.setImageResource(R.drawable.charmeleon)
                pokechoosed = DataPokemon.pokemonList[2].pokemonName
                println(pokechoosed)
            }
            3 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charizard)
                binding.imgPokeBack.setImageResource(R.drawable.charizard)
                pokechoosed = DataPokemon.pokemonList[3].pokemonName
                println(pokechoosed)
            }
            4 -> {
                binding.imgPokeFront.setImageResource(R.drawable.pikachu)
                binding.imgPokeBack.setImageResource(R.drawable.pikachu)
                pokechoosed = DataPokemon.pokemonList[4].pokemonName
                println(pokechoosed)
            }
            5 -> {
                binding.imgPokeFront.setImageResource(R.drawable.raichu)
                binding.imgPokeBack.setImageResource(R.drawable.raichu)
                pokechoosed = DataPokemon.pokemonList[5].pokemonName
                println(pokechoosed)
            }
            6 -> {
                binding.imgPokeFront.setImageResource(R.drawable.bulbasaur)
                binding.imgPokeBack.setImageResource(R.drawable.bulbasaur)
                pokechoosed = DataPokemon.pokemonList[6].pokemonName
                println(pokechoosed)
            }
            7 -> {
                binding.imgPokeFront.setImageResource(R.drawable.ivysaur)
                binding.imgPokeBack.setImageResource(R.drawable.ivysaur)
                pokechoosed = DataPokemon.pokemonList[7].pokemonName
                println(pokechoosed)
            }
            8 -> {
                binding.imgPokeFront.setImageResource(R.drawable.venusaur)
                binding.imgPokeBack.setImageResource(R.drawable.venusaur)
                pokechoosed = DataPokemon.pokemonList[8].pokemonName
                println(pokechoosed)
            }
            9 -> {
                binding.imgPokeFront.setImageResource(R.drawable.squirtle)
                binding.imgPokeBack.setImageResource(R.drawable.squirtle)
                pokechoosed = DataPokemon.pokemonList[9].pokemonName
                println(pokechoosed)
            }
            10 -> {
                binding.imgPokeFront.setImageResource(R.drawable.wartortle)
                binding.imgPokeBack.setImageResource(R.drawable.wartortle)
                pokechoosed = DataPokemon.pokemonList[10].pokemonName
                println(pokechoosed)
            }
            11 -> {
                binding.imgPokeFront.setImageResource(R.drawable.blastoise)
                binding.imgPokeBack.setImageResource(R.drawable.blastoise)
                pokechoosed = DataPokemon.pokemonList[11].pokemonName
                println(pokechoosed)
            }
            12 -> {
                binding.imgPokeFront.setImageResource(R.drawable.caterpie)
                binding.imgPokeBack.setImageResource(R.drawable.caterpie)
                pokechoosed = DataPokemon.pokemonList[12].pokemonName
                println(pokechoosed)
            }
            13 -> {
                binding.imgPokeFront.setImageResource(R.drawable.metapod)
                binding.imgPokeBack.setImageResource(R.drawable.metapod)
                pokechoosed = DataPokemon.pokemonList[13].pokemonName
                println(pokechoosed)
            }
            else -> {
                binding.imgPokeFront.setImageResource(R.drawable.charizard)
                binding.imgPokeBack.setImageResource(R.drawable.charizard)
                pokechoosed = DataPokemon.pokemonList[0].pokemonName
                println(pokechoosed)
            }
        }
        return x
    }

}
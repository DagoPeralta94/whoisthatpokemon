package com.example.whoisthatpokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.whoisthatpokemon.data.DataPokemon
import com.example.whoisthatpokemon.data.RandomPokemon
import com.example.whoisthatpokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lives: Int = 3
    private var score: Int = 0
    private var pokechoosed: String = "Charmander"
    private var counterTime: Long = 60000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        changeTextPokemon()
        binding.btSubmit.setOnClickListener {
            showPokemon()
        }
        binding.btNextPokemon.setOnClickListener {
            nextPokemon()
        }
        counterDown()
    }

    private fun chooseRandomPoke(): RandomPokemon {
        return DataPokemon.pokemonList[(1 until DataPokemon.pokemonList.size).random()]
    }

    private fun changeTextPokemon() {
        binding.txtPokeInput.addTextChangedListener {
            binding.txtPokeName.text = it
        }
    }

    private fun showPokemon() {
        with(binding) {
            if (txtPokeName.text.toString() == pokechoosed) {
                imgPokeFront.visibility = View.GONE
                btSubmit.visibility = View.GONE
                btNextPokemon.visibility = View.VISIBLE
                score += 10
                txtScore.text = score.toString()
            } else {
                Toast.makeText(txtPokeInput.context, "NOMBRE INCORRECTO", Toast.LENGTH_SHORT).show()
                lives -= 1
                txtLive.text = lives.toString()
                if (lives == 0) {
                    alertDialogShow()
                    object : CountDownTimer(1000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            binding.txtTime.text = (millisUntilFinished / 1000).toString()
                        }

                        override fun onFinish() {
                            alertDialogShow()
                        }
                    }
                }
            }
        }
    }

    private fun alertDialogShow() {
        with(binding) {
            run {
                if(lives>0 && score!= 0){
                    score += (lives * 10)
                }
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
                    counterDown()
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

    private fun nextPokemon() {
        with(binding) {
            choosePhotos()
            imgPokeFront.visibility = View.VISIBLE
            btSubmit.visibility = View.VISIBLE
            btNextPokemon.visibility = View.GONE
            txtPokeInput.text.clear()
        }
    }

    private fun choosePhotos(): Any? {
        var x = when (chooseRandomPoke().id) {
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
            14 -> {
                binding.imgPokeFront.setImageResource(R.drawable.butterfree)
                binding.imgPokeBack.setImageResource(R.drawable.butterfree)
                pokechoosed = DataPokemon.pokemonList[14].pokemonName
                println(pokechoosed)
            }
            15 -> {
                binding.imgPokeFront.setImageResource(R.drawable.weedle)
                binding.imgPokeBack.setImageResource(R.drawable.weedle)
                pokechoosed = DataPokemon.pokemonList[15].pokemonName
                println(pokechoosed)
            }
            16 -> {
                binding.imgPokeFront.setImageResource(R.drawable.kakuna)
                binding.imgPokeBack.setImageResource(R.drawable.kakuna)
                pokechoosed = DataPokemon.pokemonList[16].pokemonName
                println(pokechoosed)
            }
            17 -> {
                binding.imgPokeFront.setImageResource(R.drawable.beedrill)
                binding.imgPokeBack.setImageResource(R.drawable.beedrill)
                pokechoosed = DataPokemon.pokemonList[17].pokemonName
                println(pokechoosed)
            }
            18 -> {
                binding.imgPokeFront.setImageResource(R.drawable.pidgey)
                binding.imgPokeBack.setImageResource(R.drawable.pidgey)
                pokechoosed = DataPokemon.pokemonList[18].pokemonName
                println(pokechoosed)
            }
            19 -> {
                binding.imgPokeFront.setImageResource(R.drawable.pidgeotto)
                binding.imgPokeBack.setImageResource(R.drawable.pidgeotto)
                pokechoosed = DataPokemon.pokemonList[19].pokemonName
                println(pokechoosed)
            }
            20 -> {
                binding.imgPokeFront.setImageResource(R.drawable.pidgeot)
                binding.imgPokeBack.setImageResource(R.drawable.pidgeot)
                pokechoosed = DataPokemon.pokemonList[20].pokemonName
                println(pokechoosed)
            }
            21 -> {
                binding.imgPokeFront.setImageResource(R.drawable.rattata)
                binding.imgPokeBack.setImageResource(R.drawable.rattata)
                pokechoosed = DataPokemon.pokemonList[21].pokemonName
                println(pokechoosed)
            }
            22 -> {
                binding.imgPokeFront.setImageResource(R.drawable.raticate)
                binding.imgPokeBack.setImageResource(R.drawable.raticate)
                pokechoosed = DataPokemon.pokemonList[22].pokemonName
                println(pokechoosed)
            }
            23 -> {
                binding.imgPokeFront.setImageResource(R.drawable.spearow)
                binding.imgPokeBack.setImageResource(R.drawable.spearow)
                pokechoosed = DataPokemon.pokemonList[23].pokemonName
                println(pokechoosed)
            }
            24 -> {
                binding.imgPokeFront.setImageResource(R.drawable.fearow)
                binding.imgPokeBack.setImageResource(R.drawable.fearow)
                pokechoosed = DataPokemon.pokemonList[24].pokemonName
                println(pokechoosed)
            }
            25 -> {
                binding.imgPokeFront.setImageResource(R.drawable.ekans)
                binding.imgPokeBack.setImageResource(R.drawable.ekans)
                pokechoosed = DataPokemon.pokemonList[25].pokemonName
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

    private fun counterDown() {
        object : CountDownTimer(counterTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (lives > 0) {
                    binding.txtTime.text = (millisUntilFinished / 1000).toString()
                } else {
                    binding.txtTime.text = "0"
                    cancel()
                }
            }
            override fun onFinish() {
                alertDialogShow()
            }
        }.start()
    }
}
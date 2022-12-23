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
        return DataPokemon.pokemonList[(0 until DataPokemon.pokemonList.size).random()]
    }

    private fun changeTextPokemon(){
        binding.txtPokeInput.addTextChangedListener {
            binding.txtPokeName.text = it
        }
    }

    private fun showPokemon(){
        with(binding){
            if(txtPokeName.text.toString()=="Charmander"){
                imgPokeFront.visibility = View.GONE
                btSubmit.visibility = View.GONE
                btNextPokemon.visibility = View.VISIBLE
                score += 10
                binding.txtScore.text = score.toString()
            }else{
                Toast.makeText(txtPokeInput.context, "NOMBRE INCORRECTO", Toast.LENGTH_SHORT).show()
                lives -= 1
                binding.txtLive.text = lives.toString()
                if(lives == 0) run {
                    val builder = AlertDialog.Builder(txtPokeInput.context)
                    builder.setTitle("GAME OVER")
                    builder.setMessage("SCORE: $score\nDo you want to try again?")
                    builder.setIcon(android.R.drawable.ic_dialog_alert)

                    builder.setPositiveButton("YES") { dialogInterface, which ->
                        lives = 3
                        score = 0
                        binding.txtScore.text = score.toString()
                        binding.txtLive.text = lives.toString()
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
        }
    }


    private fun choosePhotos() : Any? {
        var x = when(chooseRandomPoke().id) {
            1 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charmander)
                binding.imgPokeBack.setImageResource(R.drawable.charmander)
            }
            2 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charmeleon)
                binding.imgPokeBack.setImageResource(R.drawable.charmeleon)
            }
            3 -> {
                binding.imgPokeFront.setImageResource(R.drawable.charizard)
                binding.imgPokeBack.setImageResource(R.drawable.charizard)
            }
            4 -> {
                binding.imgPokeFront.setImageResource(R.drawable.pikachu)
                binding.imgPokeBack.setImageResource(R.drawable.pikachu)
            }
            5 -> {
                binding.imgPokeFront.setImageResource(R.drawable.raichu)
                binding.imgPokeBack.setImageResource(R.drawable.raichu)
            }
            else -> {
                binding.imgPokeFront.setImageResource(R.drawable.charizard)
                binding.imgPokeBack.setImageResource(R.drawable.charizard)
            }
        }
        return x
    }

}
package com.example.whoisthatpokemon.data

class DataPokemon {
    companion object {
        val pokemonList = listOf<RandomPokemon>(
            RandomPokemon(
                1,
                "Charmander",
                "R.drawable.charmander"
            ),
            RandomPokemon(
                3,
                "Charizard",
                "R.drawable.charizard"
            ),
            RandomPokemon(
                2,
                "Charmeleon",
                "R.drawable.charizard"
            ),
            RandomPokemon(
                4,
                "Pikachu",
                "R.drawable.charizard"
            ),
            RandomPokemon(
                5,
                "Raichu",
                "R.drawable.charizard"
            )
        )
    }
}
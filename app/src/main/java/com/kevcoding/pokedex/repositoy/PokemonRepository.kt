package com.kevcoding.pokedex.repositoy

import com.kevcoding.pokedex.data.remote.PokeApi
import com.kevcoding.pokedex.data.remote.responses.Pokemon
import com.kevcoding.pokedex.data.remote.responses.PokemonList
import com.kevcoding.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){

    suspend fun getPokemonList(Limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(Limit, offset)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}
package com.kevcoding.pokedex.data.remote.responses
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
data class PokemonList(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String,
    @SerialName("results")
    val results: List<Result>
)

@Serializable
data class Result(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)
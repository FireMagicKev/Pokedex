package com.kevcoding.pokedex.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kevcoding.pokedex.data.remote.PokeApi
import com.kevcoding.pokedex.repositoy.PokemonRepository
import com.kevcoding.pokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun provideJson() =
        Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
        }

    @Singleton
    @Provides
    fun providePokeApi(json: Json): PokeApi {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(PokeApi::class.java)
    }
}
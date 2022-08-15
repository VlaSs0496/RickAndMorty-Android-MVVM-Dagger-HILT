package com.example.rickandmorty.data.source.remote

import com.example.rickandmorty.data.source.remote.Dto.CharacterDto
import com.example.rickandmorty.data.source.remote.Dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMorty {

    @GET("character/")
    suspend fun getCharacters(
        @Query("page") page: Int
    ):CharactersDto

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ):CharacterDto
}
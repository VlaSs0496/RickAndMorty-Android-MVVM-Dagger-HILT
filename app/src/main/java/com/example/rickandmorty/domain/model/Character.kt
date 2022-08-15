package com.example.rickandmorty.domain.model

import com.example.rickandmorty.data.source.remote.Dto.Location
import com.example.rickandmorty.data.source.remote.Dto.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: Origin,
    val gender: String,
    val location: Location,
    val image: String
)

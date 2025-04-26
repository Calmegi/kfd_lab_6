package com.example.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDTO (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
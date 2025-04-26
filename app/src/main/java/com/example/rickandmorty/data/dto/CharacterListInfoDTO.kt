package com.example.rickandmorty.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListInfoDTO(
    val count: Int,
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)
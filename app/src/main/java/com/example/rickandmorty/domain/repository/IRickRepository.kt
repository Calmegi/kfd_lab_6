package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.entity.CharacterEntity

interface IRickRepository {
    suspend fun getAllCharacters(forceRefresh: Boolean = false): List<CharacterEntity>
}
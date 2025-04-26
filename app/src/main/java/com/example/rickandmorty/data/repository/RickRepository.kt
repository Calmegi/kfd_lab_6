package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.mapper.CharacterMapper
import com.example.rickandmorty.data.service.CharacterDAO
import com.example.rickandmorty.data.service.RickApiService
import com.example.rickandmorty.domain.entity.CharacterEntity
import com.example.rickandmorty.domain.repository.IRickRepository

class RickRepository(
    private val apiService: RickApiService,
    private val dao: CharacterDAO,
): IRickRepository {
    override suspend fun getAllCharacters(forceRefresh: Boolean): List<CharacterEntity> {
        try {
            val localData = dao.getAllCharacters()
            if (localData.isEmpty() || forceRefresh) {
                val remoteData = apiService.getAllCharacters()
                dao.insertAll(remoteData.results.map { CharacterMapper.mapDTOToModel(it) })
                return remoteData.results.map { CharacterMapper.mapDTOEntity(it) }
            }
            return localData.map { CharacterMapper.mapModelToEntity(it) }
        } catch (e: Exception) {
            throw Exception(e.message + "|" + e.localizedMessage, e)
        }
    }
}

package com.example.rickandmorty.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.model.CharacterModel
import com.example.rickandmorty.data.service.CharacterDAO

@Database(
    entities = [CharacterModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDAO(): CharacterDAO
}
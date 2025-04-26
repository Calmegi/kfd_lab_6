package com.example.rickandmorty.common.di

import androidx.room.Room
import com.example.rickandmorty.common.database.AppDatabase
import com.example.rickandmorty.domain.repository.IRickRepository
import com.example.rickandmorty.data.repository.RickRepository
import com.example.rickandmorty.data.service.RickApiService
import com.example.rickandmorty.presentation.viewmodel.CharacterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}

val repositoryModule = module {
    single<IRickRepository> { RickRepository(RickApiService, get()) }
}

val appModule = module {
    single { get<AppDatabase>().characterDAO() }
}
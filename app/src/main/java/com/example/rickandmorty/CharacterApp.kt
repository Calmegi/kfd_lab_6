package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.common.di.viewModelModule
import com.example.rickandmorty.common.di.appModule
import com.example.rickandmorty.common.di.databaseModule
import com.example.rickandmorty.common.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CharacterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CharacterApp)
            modules(listOf(viewModelModule, databaseModule, repositoryModule, appModule))
        }
    }
}
package com.mayur.triviaapp.di

import android.app.Application
import com.mayur.triviaapp.data.cache.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase {
        return AppDatabase.getInstance(application.baseContext)

    }


}

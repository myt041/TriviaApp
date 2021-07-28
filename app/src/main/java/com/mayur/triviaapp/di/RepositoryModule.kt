package com.mayur.triviaapp.di

import com.mayur.triviaapp.data.cache.AppDatabase
import com.mayur.triviaapp.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun providesChatRepository(
        appDatabase: AppDatabase
    ): UserRepository {
        return UserRepository(appDatabase)
    }

}
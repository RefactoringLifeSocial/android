package com.refactoringlife.core.data.di

import android.content.Context
import com.refactoringlife.core.data.datastore.AppPreferencesRepository
import com.refactoringlife.core.data.datastore.AppPreferencesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideAppPreferencesSerializer(
        @ApplicationContext context: Context
    ): AppPreferencesSerializer {
        return AppPreferencesSerializer(context)
    }

    @Provides
    @Singleton
    fun provideAppPreferencesRepository(
        serializer: AppPreferencesSerializer
    ): AppPreferencesRepository {
        return AppPreferencesRepository(serializer)
    }
}
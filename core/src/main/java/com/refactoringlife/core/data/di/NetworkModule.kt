package com.refactoringlife.core.data.di

import com.refactoringlife.core.data.network.OKHttpProvider
import com.refactoringlife.core.data.network.RetrofitProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OKHttpProvider.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitProvider.create(okHttpClient)
    }
}

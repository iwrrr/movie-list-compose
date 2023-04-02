package com.hwaryun.movielist.di

import com.hwaryun.movielist.data.network.service.ApiService
import com.hwaryun.movielist.data.repository.MovieRepository
import com.hwaryun.movielist.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImpl(apiService)
    }
}
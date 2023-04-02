package com.hwaryun.movielist.di

import com.hwaryun.movielist.data.repository.MovieRepository
import com.hwaryun.movielist.domain.use_case.GetNowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetNowPlayingMoviesUseCase(repository: MovieRepository): GetNowPlayingMoviesUseCase {
        return GetNowPlayingMoviesUseCase(repository, Dispatchers.IO)
    }
}
package com.hwaryun.movielist.data.repository

import com.hwaryun.movielist.data.network.model.BaseResponse
import com.hwaryun.movielist.data.network.model.MovieResponse
import com.hwaryun.movielist.data.network.service.ApiService
import com.hwaryun.movielist.utils.wrapper.DataResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface MovieRepository {
    suspend fun getNowPlayingMovies(): Flow<DataResource<BaseResponse<MovieResponse>>>
}

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository, BaseRepository() {

    override suspend fun getNowPlayingMovies(): Flow<DataResource<BaseResponse<MovieResponse>>> =
        flow {
            emit(safeNetworkCall { apiService.fetchNowPlayingMovies() })
        }
}
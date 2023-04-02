package com.hwaryun.movielist.data.network.service

import com.hwaryun.movielist.data.network.model.BaseResponse
import com.hwaryun.movielist.data.network.model.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(): BaseResponse<MovieResponse>
}
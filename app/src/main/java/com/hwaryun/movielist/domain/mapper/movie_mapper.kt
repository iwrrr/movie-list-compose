package com.hwaryun.movielist.domain.mapper

import com.hwaryun.movielist.data.network.model.MovieResponse
import com.hwaryun.movielist.domain.model.Movie

fun List<MovieResponse>?.toListMovie(): List<Movie> {
    val mapperData: (MovieResponse) -> Movie = {
        Movie(
            id = it.id,
            title = it.title,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath ?: "",
            releaseDate = it.releaseDate,
            overview = it.overview,
            voteAverage = it.voteAverage
        )
    }

    return this?.map(mapperData).orEmpty()
}
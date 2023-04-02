package com.hwaryun.movielist.presentation.movie_list

import com.hwaryun.movielist.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)

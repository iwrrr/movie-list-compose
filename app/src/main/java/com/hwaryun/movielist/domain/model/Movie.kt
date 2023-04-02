package com.hwaryun.movielist.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val overview: String,
    val voteAverage: Double,
)
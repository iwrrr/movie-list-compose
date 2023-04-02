package com.hwaryun.movielist.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("genres")
    val genres: List<GenreResponse>?,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
)
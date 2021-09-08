package com.example.submissionbajp.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class TvShow(
    val id: Int = 0,
    @SerializedName("name")
    val title: String = "",
    @SerializedName("first_air_date")
    val releaseDate: String = "",
    @SerializedName("vote_average")
    val score: Double = 0.0,
    val overview: String = "",
    @SerializedName("poster_path")
    val poster: Any = "",
)
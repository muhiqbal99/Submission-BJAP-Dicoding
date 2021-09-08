package com.example.submissionbajp.data.source.local.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    val id: Int,
    val title: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("vote_average")
    val score: Double = 0.0,
    val overview: String = "",
    @SerializedName("poster_path")
    val poster: Any = "",
)
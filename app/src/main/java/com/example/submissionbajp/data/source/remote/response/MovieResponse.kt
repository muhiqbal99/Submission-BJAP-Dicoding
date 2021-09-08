package com.example.submissionbajp.data.source.remote.response

import com.example.submissionbajp.data.source.local.entity.Movie

data class MovieResponse(
    val page: Int = 0,
    val results: List<Movie>,
    val totalPages: Int = 0,
    val totalResults: Int = 0,
)
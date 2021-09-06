package com.example.submissionbajp.model

data class Movie(
    var id: Int = 0,
    var title: String,
    var releaseDate: String,
    var duration: String,
    var genre: String,
    var score: String,
    var overview: String,
    var poster: Int = 0,
)
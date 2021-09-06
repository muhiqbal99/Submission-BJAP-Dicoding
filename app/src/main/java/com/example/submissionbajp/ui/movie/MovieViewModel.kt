package com.example.submissionbajp.ui.movie

import androidx.lifecycle.ViewModel
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<Movie> = DataDummy.getMovie()
}
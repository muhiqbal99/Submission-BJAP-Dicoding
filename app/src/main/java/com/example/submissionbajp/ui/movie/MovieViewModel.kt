package com.example.submissionbajp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.Movie

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<Movie>> = movieRepository.getMovie()
}
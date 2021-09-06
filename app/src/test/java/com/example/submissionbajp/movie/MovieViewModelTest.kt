package com.example.submissionbajp.movie

import com.example.submissionbajp.ui.movie.MovieViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun init() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovieSuccess() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}
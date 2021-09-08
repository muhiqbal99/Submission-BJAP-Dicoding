package com.example.submissionbajp.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.ui.movie.MovieViewModel
import com.example.submissionbajp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovieList() {
        val dummyMovies = DataDummy.getMovie()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovies

        `when`(movieRepository.getMovie()).thenReturn(movies)
        val movieEntity = viewModel.getMovies().value
        verify(movieRepository).getMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}
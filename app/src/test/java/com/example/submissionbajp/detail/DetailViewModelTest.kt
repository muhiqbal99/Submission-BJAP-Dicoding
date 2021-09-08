package com.example.submissionbajp.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.ui.detail.DetailViewModel
import com.example.submissionbajp.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getMovie()[0]
    private val dummyTvShow = DataDummy.getTvShow()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieObserver: Observer<Movie>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShow>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDetail = MutableLiveData<Movie>()
        movieDetail.value = dummyMovie

        `when`(movieRepository.getDetailMovie(movieId)).thenReturn(movieDetail)
        val movieEntity = viewModel.getDetailMovie(movieId).value as Movie
        verify(movieRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)

        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.score, movieEntity.score, 0.0)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.poster, movieEntity.poster)

        viewModel.getDetailMovie(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }


    @Test
    fun getTvShowDetail() {
        val tvShowDetail = MutableLiveData<TvShow>()
        tvShowDetail.value = dummyTvShow

        `when`(movieRepository.getDetailTvShow(tvShowId)).thenReturn(tvShowDetail)
        val tvShowEntity = viewModel.getDetailTv(tvShowId).value as TvShow
        verify(movieRepository).getDetailTvShow(tvShowId)
        assertNotNull(tvShowEntity)

        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvShow.score, tvShowEntity.score, 0.0)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.poster, tvShowEntity.poster)

        viewModel.getDetailTv(tvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}
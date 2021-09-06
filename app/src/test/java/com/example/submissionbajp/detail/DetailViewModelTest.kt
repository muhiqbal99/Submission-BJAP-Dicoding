package com.example.submissionbajp.detail

import com.example.submissionbajp.ui.detail.DetailViewModel
import com.example.submissionbajp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dataDummyMovie = DataDummy.getMovie()[0]
    private val dataDummyTvShow = DataDummy.getTvShow()[0]
    private val idMovie = dataDummyMovie.id
    private val idTvShow = dataDummyTvShow.id


    @Before
    fun init() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovieSuccess() {
        viewModel.setSelectedItem(idMovie)
        val movieEntities = viewModel.selectedMovie()
        assertNotNull(movieEntities)
        assertEquals(dataDummyMovie.duration, movieEntities.duration)
        assertEquals(dataDummyMovie.genre, movieEntities.genre)
        assertEquals(dataDummyMovie.id, movieEntities.id)
        assertEquals(dataDummyMovie.overview, movieEntities.overview)
        assertEquals(dataDummyMovie.poster, movieEntities.poster)
        assertEquals(dataDummyMovie.releaseDate, movieEntities.releaseDate)
        assertEquals(dataDummyMovie.score, movieEntities.score)
        assertEquals(dataDummyMovie.title, movieEntities.title)
    }

    @Test
    fun getTvShowSuccess() {
        viewModel.setSelectedItem(idTvShow)
        val tvShowEntities = viewModel.selectedTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(dataDummyTvShow.duration, tvShowEntities.duration)
        assertEquals(dataDummyTvShow.genre, tvShowEntities.genre)
        assertEquals(dataDummyTvShow.id, tvShowEntities.id)
        assertEquals(dataDummyTvShow.overview, tvShowEntities.overview)
        assertEquals(dataDummyTvShow.poster, tvShowEntities.poster)
        assertEquals(dataDummyTvShow.releaseDate, tvShowEntities.releaseDate)
        assertEquals(dataDummyTvShow.score, tvShowEntities.score)
        assertEquals(dataDummyTvShow.title, tvShowEntities.title)
    }

}
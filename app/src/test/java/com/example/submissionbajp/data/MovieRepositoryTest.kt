package com.example.submissionbajp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.submissionbajp.LiveDataTest
import com.example.submissionbajp.data.source.remote.RemoteDataSource
import com.example.submissionbajp.utils.DataDummy
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val dataRepositoryTest = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.getMovie()
    private val movieId = movieResponses[0].id
    private val tvShowResponse = DataDummy.getTvShow()
    private val tvShowId = tvShowResponse[0].id


    @Test
    fun getMovieDetail() {
        doAnswer {
            val callback = it.arguments[1] as RemoteDataSource.GetMovieDetailCallback
            callback.onResponse(movieResponses[0])
            null
        }.`when`(remote)
            .getMovieDetail(eq(movieId), any())

        val movieDetail = LiveDataTest.getValue(dataRepositoryTest.getDetailMovie(movieId))

        verify(remote).getMovieDetail(eq(movieId), any())

        assertNotNull(movieDetail)
        assertEquals(movieResponses[0].title, movieDetail.title)
        assertEquals(movieResponses[0].releaseDate, movieDetail.releaseDate)
        assertEquals(movieResponses[0].score, movieDetail.score, 0.0)
        assertEquals(movieResponses[0].overview, movieDetail.overview)
        assertEquals(movieResponses[0].poster, movieDetail.poster)
    }

    @Test
    fun getTvShowDetail() {
        doAnswer {
            val callback = it.arguments[1] as RemoteDataSource.GetTvShowDetailCallback
            callback.onResponse(tvShowResponse[0])
            null
        }.`when`(remote).getTvShowDetail(eq(tvShowId), any())

        val tvShowDetail = LiveDataTest.getValue(dataRepositoryTest.getDetailTvShow(tvShowId))
        verify(remote).getTvShowDetail(eq(tvShowId), any())

        assertNotNull(tvShowDetail)
        assertEquals(tvShowResponse[0].title, tvShowDetail.title)
        assertEquals(tvShowResponse[0].releaseDate, tvShowDetail.releaseDate)
        assertEquals(tvShowResponse[0].score, tvShowDetail.score, 0.0)
        assertEquals(tvShowResponse[0].overview, tvShowDetail.overview)
        assertEquals(tvShowResponse[0].poster, tvShowDetail.poster)
    }

    @Test
    fun getMovie() {
        doAnswer {
            val callback = it.arguments[0] as RemoteDataSource.GetMovieCallback
            callback.onResponse(movieResponses)
            null
        }.`when`(remote).getMovie(any())

        val result = LiveDataTest.getValue(dataRepositoryTest.getMovie())
        assertEquals(movieResponses.size, result.size)
    }

    @Test
    fun getTvShow() {
        Mockito.doAnswer {
            val callback = it.arguments[0] as RemoteDataSource.GetTvShowCallback
            callback.onResponse(tvShowResponse)
            null
        }.`when`(remote).getTvShow(any())

        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShow())
        assertEquals(tvShowResponse.size, result.size)
    }

}
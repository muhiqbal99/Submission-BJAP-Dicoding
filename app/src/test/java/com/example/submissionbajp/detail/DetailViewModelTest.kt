package com.example.submissionbajp.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.ui.detail.DetailViewModel
import com.example.submissionbajp.utils.DataDummy
import com.example.submissionbajp.vo.Resource
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

    private val dummyMovie = Resource.Success(DataDummy.getItems()[0])
    private val dummyTvShow = Resource.Success(DataDummy.getItemsTvShow()[0])
    private val movieId = dummyMovie.data?.id
    private val tvShowId = dummyTvShow.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var itemsEntityObserver: Observer<Resource<ItemsEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<ItemsEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(itemRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDetail = MutableLiveData<Resource<ItemsEntity>>()
        movieDetail.value = dummyMovie

        `when`(movieId?.let { itemRepository.getDetailMovie(it) }).thenReturn(movieDetail)
        val movieEntity = movieId?.let { viewModel.getDetailMovie(it).value?.data } as ItemsEntity
        verify(itemRepository).getDetailMovie(movieId)
        assertNotNull(movieEntity)

        assertEquals(dummyMovie.data?.id, movieEntity.id)
        assertEquals(dummyMovie.data?.title, movieEntity.title)
        assertEquals(dummyMovie.data?.releaseDate, movieEntity.releaseDate)
        dummyMovie.data?.score?.let { assertEquals(it, movieEntity.score, 0.0) }
        assertEquals(dummyMovie.data?.overview, movieEntity.overview)
        assertEquals(dummyMovie.data?.poster, movieEntity.poster)

        viewModel.getDetailMovie(movieId).observeForever(itemsEntityObserver)
        verify(itemsEntityObserver).onChanged(dummyMovie)
    }


    @Test
    fun getTvShowDetail() {
        val tvShowDetail = MutableLiveData<Resource<ItemsEntity>>()
        tvShowDetail.value = dummyTvShow

        `when`(tvShowId?.let { itemRepository.getDetailTvShow(it) }).thenReturn(tvShowDetail)
        val tvShowEntity =
            tvShowId?.let { viewModel.getDetailTvShow(it).value?.data } as ItemsEntity
        verify(itemRepository).getDetailTvShow(tvShowId)
        assertNotNull(tvShowEntity)

        assertEquals(dummyTvShow.data?.id, tvShowEntity.id)
        assertEquals(dummyTvShow.data?.title, tvShowEntity.title)
        assertEquals(dummyTvShow.data?.releaseDate, tvShowEntity.releaseDate)
        dummyTvShow.data?.score?.let { assertEquals(it, tvShowEntity.score, 0.0) }
        assertEquals(dummyTvShow.data?.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.data?.poster, tvShowEntity.poster)

        viewModel.getDetailTvShow(tvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}
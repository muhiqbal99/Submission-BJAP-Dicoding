package com.example.submissionbajp.item

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.ui.movie.MovieViewModel
import com.example.submissionbajp.ui.tvshow.TvShowViewModel
import com.example.submissionbajp.utils.DataDummy
import com.example.submissionbajp.vo.Resource
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
class ItemsViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private lateinit var viewModelTv: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<ItemsEntity>>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(itemRepository)
        viewModelTv = TvShowViewModel(itemRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovies = Resource.Success(DataDummy.getItems())
        val movies = MutableLiveData<Resource<List<ItemsEntity>>>()
        movies.value = dummyMovies

        `when`(itemRepository.getMovie()).thenReturn(movies)
        val movieEntity = viewModel.getMovies().value?.data
        verify(itemRepository).getMovie()
        assertNotNull(movieEntity)
        assertEquals(10, movieEntity?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = Resource.Success(DataDummy.getItemsTvShow())
        val tvShow = MutableLiveData<Resource<List<ItemsEntity>>>()
        tvShow.value = dummyTvShow

        `when`(itemRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModelTv.getTvShow().value?.data
        verify(itemRepository).getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity?.size)

        viewModelTv.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}
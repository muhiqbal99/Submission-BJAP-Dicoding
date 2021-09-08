package com.example.submissionbajp.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.ui.tvshow.TvShowViewModel
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataDummy.getTvShow()
        val tvShow = MutableLiveData<List<TvShow>>()
        tvShow.value = dummyTvShow

        `when`(tvShowRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShow().value
        verify(tvShowRepository).getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(1, tvShowEntity?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}
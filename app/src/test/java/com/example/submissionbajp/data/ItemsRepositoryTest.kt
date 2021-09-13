package com.example.submissionbajp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.submissionbajp.LiveDataTest
import com.example.submissionbajp.PagedListUtil
import com.example.submissionbajp.data.source.local.LocalDataSource
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.data.source.remote.RemoteDataSource
import com.example.submissionbajp.utils.AppExecutors
import com.example.submissionbajp.utils.DataDummy
import com.example.submissionbajp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ItemsRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val dataRepositoryTest = FakeItemRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.getItems()
    private val movieId = movieResponses[0].id
    private val tvShowResponse = DataDummy.getItemsTvShow()
    private val tvShowId = tvShowResponse[0].id


    @Test
    fun getMovieDetail() {
        val movieDetail = MutableLiveData<ItemsEntity>()
        movieDetail.value = DataDummy.getItems()[0]
        `when`(local.getMovieById(movieId)).thenReturn(movieDetail)

        val movieEntities = LiveDataTest.getValue(dataRepositoryTest.getDetailMovie(movieId))
        verify(local).getMovieById(movieId)

        assertNotNull(movieEntities.data)
        assertEquals(movieResponses[0].title, movieEntities.data?.title)
        assertEquals(movieResponses[0].releaseDate, movieEntities.data?.releaseDate)
        assertEquals(movieResponses[0].score, movieEntities.data?.score)
        assertEquals(movieResponses[0].overview, movieEntities.data?.overview)
    }

    @Test
    fun getTvShowDetail() {
        val tvShowDetail = MutableLiveData<ItemsEntity>()
        tvShowDetail.value = DataDummy.getItemsTvShow()[0]
        `when`(local.getTvShowById(tvShowId)).thenReturn(tvShowDetail)

        val tvShowEntities = LiveDataTest.getValue(dataRepositoryTest.getDetailTvShow(tvShowId))
        verify(local).getTvShowById(tvShowId)

        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse[0].title, tvShowEntities.data?.title)
        assertEquals(tvShowResponse[0].releaseDate, tvShowEntities.data?.releaseDate)
        assertEquals(tvShowResponse[0].score, tvShowEntities.data?.score)
        assertEquals(tvShowResponse[0].overview, tvShowEntities.data?.overview)
    }

    @Test
    fun getMovie() {
        val movieList = MutableLiveData<List<ItemsEntity>>()
        movieList.value = DataDummy.getItems()
        `when`(local.getMovieItem()).thenReturn(movieList)

        val movieEntities = LiveDataTest.getValue(dataRepositoryTest.getMovie())
        verify(local).getMovieItem()
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShow() {
        val tvShowList = MutableLiveData<List<ItemsEntity>>()
        tvShowList.value = DataDummy.getItemsTvShow()
        `when`(local.getTvShowItem()).thenReturn(tvShowList)

        val movieEntities = LiveDataTest.getValue(dataRepositoryTest.getTvShow())
        verify(local).getTvShowItem()
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteItem() {
        val dataSourceFactory = mock(DataSource.Factory::class.java)
        `when`(local.getFavoriteItemList()).thenReturn(dataSourceFactory as DataSource.Factory<Int, ItemsEntity>)
        dataRepositoryTest.getFavoriteItem()
        verify(local).getFavoriteItemList()

        val itemEntities = Resource.Success(PagedListUtil.mockPagedList(DataDummy.getItems()))
        verify(local).getFavoriteItemList()
        assertNotNull(itemEntities)
        assertEquals(movieResponses.size.toLong(), itemEntities.data?.size?.toLong())
    }
}

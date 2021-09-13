package com.example.submissionbajp.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.ui.favorite.FavoriteViewModel
import com.example.submissionbajp.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ItemsEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(itemRepository)
    }

    @Test
    fun `getItemFavorite should be success`() {
        val expected = MutableLiveData<PagedList<ItemsEntity>>()
        expected.value = PagedTestDataSources.snapshot(DataDummy.getItems())

        `when`(itemRepository.getFavoriteItem()).thenReturn(expected)

        viewModel.getFavoriteItem().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteItem().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getItemFavorite should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<ItemsEntity>>()
        expected.value = PagedTestDataSources.snapshot()

        `when`(itemRepository.getFavoriteItem()).thenReturn(expected)

        viewModel.getFavoriteItem().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val actualValueDataSize = viewModel.getFavoriteItem().value?.size
        assertTrue("size of data should be 0, actual is $actualValueDataSize",
            actualValueDataSize == 0)
    }

    class PagedTestDataSources private constructor(private val items: List<ItemsEntity>) :
        PositionalDataSource<ItemsEntity>() {
        companion object {
            fun snapshot(items: List<ItemsEntity> = listOf()): PagedList<ItemsEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<ItemsEntity>,
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ItemsEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}
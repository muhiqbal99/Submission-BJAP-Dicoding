package com.example.submissionbajp.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.data.source.local.room.ItemDao

class LocalDataSource private constructor(private val itemDao: ItemDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(itemDao: ItemDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(itemDao)
    }

    fun getMovieItem(): LiveData<List<ItemsEntity>> = itemDao.getItems("movie")

    fun getTvShowItem(): LiveData<List<ItemsEntity>> = itemDao.getItems("tvshow")

    fun getMovieById(id: Int): LiveData<ItemsEntity> = itemDao.getMovieById(id)

    fun getTvShowById(id: Int): LiveData<ItemsEntity> = itemDao.getTvShowById(id)

    fun insertItems(items: List<ItemsEntity>) = itemDao.insertItem(items)

    fun insertDetail(items: List<ItemsEntity>) = itemDao.insertDetail(items)

    fun getFavoriteItemList(): DataSource.Factory<Int, ItemsEntity> = itemDao.getFavoriteList()

    fun setFavorite(items: ItemsEntity, newState: Boolean) {
        items.isFavorite = newState
        itemDao.updateItem(items)
    }
}
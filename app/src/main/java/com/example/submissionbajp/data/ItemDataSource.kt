package com.example.submissionbajp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.vo.Resource

interface ItemDataSource {

    fun getMovie(): LiveData<Resource<List<ItemsEntity>>>

    fun getDetailMovie(id: Int): LiveData<Resource<ItemsEntity>>

    fun getTvShow(): LiveData<Resource<List<ItemsEntity>>>

    fun getDetailTvShow(id: Int): LiveData<Resource<ItemsEntity>>

    fun getFavoriteItem(): LiveData<PagedList<ItemsEntity>>

    fun setFavorite(items: ItemsEntity, state: Boolean)
}
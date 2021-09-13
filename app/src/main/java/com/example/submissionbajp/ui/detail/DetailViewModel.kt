package com.example.submissionbajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.vo.Resource

class DetailViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    fun getDetailMovie(id: Int): LiveData<Resource<ItemsEntity>> = itemRepository.getDetailMovie(id)

    fun getDetailTvShow(id: Int): LiveData<Resource<ItemsEntity>> =
        itemRepository.getDetailTvShow(id)

    fun setFavoriteItem(item: ItemsEntity, newState: Boolean) {
        itemRepository.setFavorite(item, newState)
    }
}
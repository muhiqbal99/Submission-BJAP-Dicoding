package com.example.submissionbajp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity

class FavoriteViewModel(private val favoriteRepository: ItemRepository) : ViewModel() {

    fun getFavoriteItem(): LiveData<PagedList<ItemsEntity>> = favoriteRepository.getFavoriteItem()

}
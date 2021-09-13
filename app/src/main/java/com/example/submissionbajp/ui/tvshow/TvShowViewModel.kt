package com.example.submissionbajp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.vo.Resource

class TvShowViewModel(private val movieRepository: ItemRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<List<ItemsEntity>>> = movieRepository.getTvShow()
}
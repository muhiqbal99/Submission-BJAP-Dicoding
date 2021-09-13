package com.example.submissionbajp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.vo.Resource

class MovieViewModel(private val movieRepository: ItemRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<ItemsEntity>>> = movieRepository.getMovie()
}
package com.example.submissionbajp.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.TvShow

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShow>> = movieRepository.getTvShow()
}
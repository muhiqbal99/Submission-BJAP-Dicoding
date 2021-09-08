package com.example.submissionbajp.data.source

import androidx.lifecycle.LiveData
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow

interface MovieDataSource {

    fun getMovie(): LiveData<List<Movie>>

    fun getDetailMovie(id: Int): LiveData<Movie>

    fun getTvShow(): LiveData<List<TvShow>>

    fun getDetailTvShow(id: Int): LiveData<TvShow>
}
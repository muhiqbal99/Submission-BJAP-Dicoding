package com.example.submissionbajp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.utils.DataDummy

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var id: Int = 0
    private val movie = MutableLiveData<Movie>()

    fun setSelectedItem(id: Int) {
        this.id = id
    }

    fun getDetailMovie(id: Int): LiveData<Movie> = movieRepository.getDetailMovie(id)

    fun getDetailTv(id: Int): LiveData<TvShow> = movieRepository.getDetailTvShow(id)

    fun selectedTvShow(): TvShow {
        lateinit var tvShow: TvShow
        for (tvShowEntity in DataDummy.getTvShow()) {
            if (tvShowEntity.id == id) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }

    fun selectedMovie(): Movie {
        lateinit var movie: Movie
        for (movieEntity in DataDummy.getMovie()) {
            if (movieEntity.id == id) {
                movie = movieEntity
            }
        }
        return movie
    }
}
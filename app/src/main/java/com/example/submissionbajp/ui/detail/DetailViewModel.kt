package com.example.submissionbajp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.utils.DataDummy

class DetailViewModel : ViewModel() {

    private var id: Int = 0

    fun setSelectedItem(id: Int) {
        this.id = id
    }

    fun selectedTvShow(): Movie {
        lateinit var tvShow: Movie
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
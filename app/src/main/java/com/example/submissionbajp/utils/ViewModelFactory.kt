package com.example.submissionbajp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissionbajp.data.source.MovieRepository
import com.example.submissionbajp.di.Injection
import com.example.submissionbajp.ui.detail.DetailViewModel
import com.example.submissionbajp.ui.movie.MovieViewModel
import com.example.submissionbajp.ui.tvshow.TvShowViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.movieRepository())
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(
                movieRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(
                movieRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(
                movieRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }
    }
}
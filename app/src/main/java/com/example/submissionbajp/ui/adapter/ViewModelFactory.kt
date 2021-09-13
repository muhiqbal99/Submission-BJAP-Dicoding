package com.example.submissionbajp.ui.adapter

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissionbajp.data.ItemRepository
import com.example.submissionbajp.di.Injection
import com.example.submissionbajp.ui.detail.DetailViewModel
import com.example.submissionbajp.ui.favorite.FavoriteViewModel
import com.example.submissionbajp.ui.movie.MovieViewModel
import com.example.submissionbajp.ui.tvshow.TvShowViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val movieRepository: ItemRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(
                movieRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(
                movieRepository) as T
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(
                movieRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(
                movieRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }
    }
}
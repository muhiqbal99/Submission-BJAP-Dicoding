package com.example.submissionbajp.ui.detail

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.submissionbajp.R
import com.example.submissionbajp.databinding.ActivityDetailBinding
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.ui.movie.MovieFragment.Companion.CLICK_MOVIE
import com.example.submissionbajp.ui.tvshow.TvShowFragment.Companion.CLICK_TV
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getIntExtra(CLICK, 0)) {
            CLICK_TV -> showTvShow(intent.getIntExtra(ID, 0))
            CLICK_MOVIE -> showMovies(intent.getIntExtra(ID, 0))
        }
    }

    private fun showMovies(id: Int) {
        viewModel.setSelectedItem(id)
        populateData(viewModel.selectedMovie())
    }

    private fun showTvShow(id: Int) {
        viewModel.setSelectedItem(id)
        populateData(viewModel.selectedTvShow())
    }

    private fun populateData(movie: Movie) {
        binding.apply {
            tvDuration.text = movie.duration
            tvGenre.text = movie.genre
            tvOverview.text = movie.overview
            tvRating.text = movie.score
            tvReleaseDate.text = movie.releaseDate
            tvTitle.text = movie.title

            setImage(ivHeader, ivPoster, movie)
        }

    }

    private fun setImage(ivHeader: ImageView, ivPoster: ImageView, movie: Movie) {
        Glide.with(this)
            .load(movie.poster)
            .apply(bitmapTransform(BlurTransformation(15, 3))
                .placeholder(R.drawable.logo)
                .error(R.drawable.ic_error))
            .into(ivHeader)

        Glide.with(this)
            .load(movie.poster)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.logo)
                .error(R.drawable.ic_error))
            .into(ivPoster)
    }

    companion object {
        const val ID = "id"
        const val CLICK = "click"
    }
}
package com.example.submissionbajp.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.submissionbajp.R
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.data.source.local.entity.TvShow
import com.example.submissionbajp.databinding.ActivityDetailBinding
import com.example.submissionbajp.ui.movie.MovieFragment.Companion.CLICK_MOVIE
import com.example.submissionbajp.ui.tvshow.TvShowFragment.Companion.CLICK_TV
import com.example.submissionbajp.utils.Constants.Companion.BASE_IMG
import com.example.submissionbajp.utils.ViewModelFactory
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val factory = ViewModelFactory.getInstance()

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
        showLoading(true)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.getDetailMovie(id).observe(this, {
            showLoading(false)
            populateData(it)
        })
    }

    private fun showTvShow(id: Int) {
        showLoading(true)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.getDetailTv(id).observe(this, {
            showLoading(false)
            populateDataTv(it)
        })
    }

    private fun populateDataTv(tvShow: TvShow) {
        binding.apply {

            tvOverview.text = tvShow.overview
            tvRating.text = tvShow.score.toString()
            tvReleaseDate.text = tvShow.releaseDate
            tvTitle.text = tvShow.title

            setPoster(BASE_IMG + "${tvShow.poster}", ivPoster)
            setHeader(BASE_IMG + "${tvShow.poster}", ivHeader)
        }
    }

    private fun populateData(movie: Movie) {
        binding.apply {

            tvOverview.text = movie.overview
            tvRating.text = movie.score.toString()
            tvReleaseDate.text = movie.releaseDate
            tvTitle.text = movie.title

            setPoster(BASE_IMG + "${movie.poster}", ivPoster)
            setHeader(BASE_IMG + "${movie.poster}", ivHeader)
        }

    }

    private fun setPoster(url: String, view: ImageView) {
        Glide.with(this)
            .load(url)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.logo)
                .error(R.drawable.ic_error))
            .into(view)
    }

    private fun setHeader(url: String, view: ImageView) {
        Glide.with(this)
            .load(url)
            .apply(bitmapTransform(BlurTransformation(15, 3))
                .placeholder(R.drawable.logo)
                .error(R.drawable.ic_error))
            .into(view)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object {
        const val ID = "id"
        const val CLICK = "click"
    }
}
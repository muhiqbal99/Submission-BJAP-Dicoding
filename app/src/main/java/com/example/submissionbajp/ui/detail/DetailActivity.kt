package com.example.submissionbajp.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.submissionbajp.R
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.databinding.ActivityDetailBinding
import com.example.submissionbajp.ui.adapter.ViewModelFactory
import com.example.submissionbajp.ui.movie.MovieFragment.Companion.CLICK_MOVIE
import com.example.submissionbajp.ui.tvshow.TvShowFragment.Companion.CLICK_TV
import com.example.submissionbajp.utils.Constants.Companion.BASE_IMG
import com.example.submissionbajp.vo.Resource
import jp.wasabeef.glide.transformations.BlurTransformation

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val factory = ViewModelFactory.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getIntExtra(CLICK, 0)) {
            CLICK_TV -> showTvShow(intent.getIntExtra(ID, 1))
            CLICK_MOVIE -> showMovies(intent.getIntExtra(ID, 2))
        }
    }

    private fun showMovies(id: Int) {
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.getDetailMovie(id).observe(this, { detailMovie ->
            if (detailMovie != null) {
                when (detailMovie) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        if (detailMovie.data != null) {
                            var state = detailMovie.data.isFavorite
                            setFavoriteState(state)
                            binding.btnFav.setOnClickListener {
                                state = !state
                                viewModel.setFavoriteItem(detailMovie.data, state)
                                setFavoriteState(state)
                            }
                            setFavoriteState(state)
                            populateData(detailMovie.data)
                        }
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        Toast.makeText(applicationContext, R.string.error, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
    }

    private fun showTvShow(id: Int) {
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.getDetailTvShow(id).observe(this, { detailTvShow ->
            if (detailTvShow != null) {
                when (detailTvShow) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        if (detailTvShow.data != null) {
                            showLoading(false)
                            var state = detailTvShow.data.isFavorite
                            setFavoriteState(state)
                            binding.btnFav.setOnClickListener {
                                state = !state
                                viewModel.setFavoriteItem(detailTvShow.data, state)
                                setFavoriteState(state)
                            }
                            populateDataTv(detailTvShow.data)
                        }
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
    }

    private fun setFavoriteState(state: Boolean) {
        when (state) {
            true -> binding.btnFav.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.ic_bookmarks))
            false -> binding.btnFav.setImageDrawable(ContextCompat.getDrawable(this,
                R.drawable.ic_unbookmarks))
        }
    }

    private fun populateDataTv(tvShow: ItemsEntity) {
        binding.apply {

            tvOverview.text = tvShow.overview
            tvRating.text = tvShow.score.toString()
            tvReleaseDate.text = tvShow.releaseDate
            tvTitle.text = tvShow.title

            setPoster(BASE_IMG + tvShow.poster, ivPoster)
            setHeader(BASE_IMG + tvShow.poster, ivHeader)
        }
    }

    private fun populateData(itemsEntity: ItemsEntity) {
        binding.apply {

            tvOverview.text = itemsEntity.overview
            tvRating.text = itemsEntity.score.toString()
            tvReleaseDate.text = itemsEntity.releaseDate
            tvTitle.text = itemsEntity.title

            setPoster(BASE_IMG + itemsEntity.poster, ivPoster)
            setHeader(BASE_IMG + itemsEntity.poster, ivHeader)
        }

    }

    private fun setPoster(url: String, view: ImageView) {
        Glide.with(this)
            .load(url)
            .transform(RoundedCorners(10))
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

    override fun onBackPressed() {
        NavUtils.navigateUpFromSameTask(this)
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
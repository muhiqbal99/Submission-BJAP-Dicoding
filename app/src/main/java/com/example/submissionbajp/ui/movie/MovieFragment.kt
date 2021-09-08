package com.example.submissionbajp.ui.movie

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.databinding.FragmentMovieBinding
import com.example.submissionbajp.ui.detail.DetailActivity
import com.example.submissionbajp.utils.ViewModelFactory

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            showLoading(true)
            viewModel.getMovies().observe(viewLifecycleOwner, {
                showLoading(false)
                movieAdapter.setData(it)
            })

            binding.rvMovie.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = movieAdapter
            }

            movieAdapter.setOnClickCallback(object : MovieAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.CLICK, CLICK_MOVIE)
                    intent.putExtra(DetailActivity.ID, data.id)
                    Log.d(TAG, "onItemClicked: ${data.id}")
                    startActivity(intent)
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val CLICK_MOVIE = 1
    }

}
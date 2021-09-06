package com.example.submissionbajp.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionbajp.adapter.MovieAdapter
import com.example.submissionbajp.databinding.FragmentMovieBinding
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.ui.detail.DetailActivity

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by viewModels()

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

            val movies = viewModel.getMovies()
            val movieAdapter = MovieAdapter()
            movieAdapter.setData(movies)

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
                    startActivity(intent)
                }
            })
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
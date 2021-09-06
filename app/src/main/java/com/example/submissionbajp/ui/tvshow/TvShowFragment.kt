package com.example.submissionbajp.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionbajp.adapter.MovieAdapter
import com.example.submissionbajp.databinding.FragmentTvShowBinding
import com.example.submissionbajp.model.Movie
import com.example.submissionbajp.ui.detail.DetailActivity
import com.example.submissionbajp.ui.detail.DetailActivity.Companion.CLICK
import com.example.submissionbajp.ui.detail.DetailActivity.Companion.ID

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val tvShow = viewModel.getTvShow()
            val tvShowAdapter = MovieAdapter()
            tvShowAdapter.setData(tvShow)

            binding.rvTvShow.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = tvShowAdapter
            }

            tvShowAdapter.setOnClickCallback(object : MovieAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(CLICK, CLICK_TV)
                    intent.putExtra(ID, data.id)
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
        const val CLICK_TV = 2
    }
}
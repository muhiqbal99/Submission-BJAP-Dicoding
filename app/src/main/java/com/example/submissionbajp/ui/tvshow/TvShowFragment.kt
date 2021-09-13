package com.example.submissionbajp.ui.tvshow

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.databinding.FragmentItemBinding
import com.example.submissionbajp.ui.adapter.ItemAdapter
import com.example.submissionbajp.ui.adapter.ViewModelFactory
import com.example.submissionbajp.ui.detail.DetailActivity
import com.example.submissionbajp.ui.detail.DetailActivity.Companion.CLICK
import com.example.submissionbajp.ui.detail.DetailActivity.Companion.ID
import com.example.submissionbajp.vo.Resource

class TvShowFragment : Fragment() {

    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding
    private val tvShowAdapter = ItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): ConstraintLayout? {
        _binding = FragmentItemBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]


            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            tvShowAdapter.setData(tvShow.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            binding?.rvItems?.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 2)
                adapter = tvShowAdapter
            }

            tvShowAdapter.setOnClickCallback(object : ItemAdapter.OnItemClickCallback {
                override fun onItemClicked(data: ItemsEntity) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(CLICK, CLICK_TV)
                    intent.putExtra(ID, data.id)
                    Log.d(TAG, "onItemClicked: ${data.id}")
                    startActivity(intent)
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
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
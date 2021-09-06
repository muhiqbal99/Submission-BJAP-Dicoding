package com.example.submissionbajp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionbajp.R
import com.example.submissionbajp.databinding.MovieListBinding
import com.example.submissionbajp.model.Movie

class MovieAdapter :
    RecyclerView.Adapter<MovieAdapter.MovieMyViewHolder>() {

    private val mData = ArrayList<Movie>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    fun setData(items: List<Movie>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MovieAdapter.MovieMyViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieMyViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieMyViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class MovieMyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = MovieListBinding.bind(itemView)
        fun bind(movieItem: Movie) {
            binding.apply {
                Glide.with(itemView)
                    .load(movieItem.poster)
                    .into(imgLogo)

                tvTitle.text = movieItem.title
                tvRating.text = movieItem.score
                val genre = movieItem.genre
                val genreSingle = genre.split(",").toTypedArray()
                tvGenre.text = genreSingle[0]
                root.setOnClickListener {
                    onItemClickCallback?.onItemClicked(movieItem)
                }
            }

        }
    }

}

package com.example.submissionbajp.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionbajp.R
import com.example.submissionbajp.data.source.local.entity.Movie
import com.example.submissionbajp.databinding.MovieListBinding
import com.example.submissionbajp.utils.Constants.Companion.BASE_IMG

class MovieAdapter :
    RecyclerView.Adapter<MovieAdapter.MovieMyViewHolder>() {

    private var mData: List<Movie> = emptyList()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    fun setData(items: List<Movie>) {
        this.mData = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MovieMyViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieMyViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MovieMyViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class MovieMyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding = MovieListBinding.bind(itemView)
        fun bind(movieItem: Movie) {
            binding.apply {
                Glide.with(itemView)
                    .load(BASE_IMG + movieItem.poster)
                    .into(imgLogo)

                tvTitle.text = movieItem.title
                tvRating.text = movieItem.score.toString()
                root.setOnClickListener {
                    onItemClickCallback?.onItemClicked(movieItem)
                }
            }

        }
    }

}

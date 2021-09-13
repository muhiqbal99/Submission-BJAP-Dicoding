package com.example.submissionbajp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionbajp.data.source.local.entity.ItemsEntity
import com.example.submissionbajp.databinding.ItemListBinding
import com.example.submissionbajp.utils.Constants

class FavoriteAdapter :
    PagedListAdapter<ItemsEntity, FavoriteAdapter.FavoriteViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ItemsEntity>() {
            override fun areItemsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemsEntity, newItem: ItemsEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ItemsEntity)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemsBookmarkBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val itemsEntity = getItem(position)
        if (itemsEntity != null) {
            holder.bind(itemsEntity)
        }
    }

    inner class FavoriteViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemsEntityItem: ItemsEntity) {
            binding.apply {
                Glide.with(itemView)
                    .load(Constants.BASE_IMG + itemsEntityItem.poster)
                    .into(imgLogo)

                tvTitle.text = itemsEntityItem.title
                tvRating.text = itemsEntityItem.score.toString()
                root.setOnClickListener {
                    onItemClickCallback?.onItemClicked(itemsEntityItem)
                }
            }
        }
    }

}
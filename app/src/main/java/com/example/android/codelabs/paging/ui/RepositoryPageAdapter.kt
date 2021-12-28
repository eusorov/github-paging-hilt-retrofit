package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.codelabs.paging.databinding.RecyclerviewItemRowBinding
import com.example.android.codelabs.paging.model.RepositoryViewData

class RepositoryPageAdapter :
    PagingDataAdapter<RepositoryViewData, RepositoryPageAdapter.RepositoryViewHolder>(RepoComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
        val bindingView = RecyclerviewItemRowBinding.inflate(layoutView, parent, false)

        return RepositoryViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RepositoryViewHolder(private val itemRowBinding: RecyclerviewItemRowBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {

        fun bind(repositoryViewData: RepositoryViewData?) {
            Glide.with(itemView.context)
                .load(repositoryViewData?.ownerImage)
                .into(itemRowBinding.avatarImage)

            itemRowBinding.ownerName.text = repositoryViewData?.ownerName
            itemRowBinding.repositoryName.text = repositoryViewData?.repositoryName
            itemRowBinding.repositoryUrl.text = repositoryViewData?.repositoryUrl
            itemRowBinding.repositoryDescription.text = repositoryViewData?.repositoryDescription

        }
    }

    object RepoComparator : DiffUtil.ItemCallback<RepositoryViewData>() {
        override fun areItemsTheSame(
            oldItem: RepositoryViewData,
            newItem: RepositoryViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepositoryViewData,
            newItem: RepositoryViewData
        ): Boolean {
            return oldItem == newItem
        }
    }
}
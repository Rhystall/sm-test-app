package com.rhystalgie.smtestapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rhystalgie.smtestapp.api.User
import com.rhystalgie.smtestapp.databinding.ItemUserBinding

class UserAdapter(private val onClick: (User) -> Unit) :
    PagingDataAdapter<User, UserAdapter.UserViewHolder>(DIFF_CALLBACK) {

    inner class UserViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.tvName.text = "${user.first_name} ${user.last_name}"
            binding.tvEmail.text = user.email
            Glide.with(binding.ivAvatar.context)
                .load(user.avatar)
                .into(binding.ivAvatar)

            binding.root.setOnClickListener { onClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        if (user != null) holder.bind(user)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
        }
    }
}

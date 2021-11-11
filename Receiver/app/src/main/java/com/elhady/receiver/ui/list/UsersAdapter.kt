package com.elhady.receiver.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.receiver.data.model.User
import com.elhady.receiver.databinding.UserItemBinding

/**
 * Created by islam elhady on 11-Nov-21.
 */
class UsersAdapter() :
    ListAdapter<User, UsersAdapter.UserHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    class UserHolder(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }
}
package com.elhady.emitter.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.elhady.emitter.data.model.User
import com.elhady.emitter.databinding.ItemUserBinding

/**
 * Created by islam elhady on 08-Nov-21.
 */
class UsersAdapter(val callback: UserClick) :
    ListAdapter<User, UsersAdapter.UserHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class UserHolder(val viewDataBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(listener: UserClick, user: User) {
            viewDataBinding.user = user
            viewDataBinding.userClick = listener
            viewDataBinding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): UserHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
                return UserHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.viewDataBinding.also {
            holder.bind(callback, getItem(position))
        }
    }
}

class UserClick(val block: (User) -> Unit) {
    /**
     * Called when a item is clicked
     * @param user the user that was clicked
     */
    fun onClick(item: User) = block(item)
}
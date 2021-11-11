package com.elhady.receiver.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.elhady.receiver.data.model.User
import com.elhady.receiver.ui.list.UsersAdapter

/**
 * Created by islam elhady on 11-Nov-21.
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    val adapter = recyclerView.adapter as UsersAdapter
    adapter.submitList(data)
}

@BindingAdapter("itemDecoration")
fun bindItemDecoration(recyclerView: RecyclerView, orientation: Int) {
    val mDividerItemDecoration = DividerItemDecoration(
        recyclerView.context, orientation
    )
    recyclerView.addItemDecoration(mDividerItemDecoration)
}


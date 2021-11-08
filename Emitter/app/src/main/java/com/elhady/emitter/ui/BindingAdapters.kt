package com.elhady.emitter.ui

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.elhady.emitter.data.model.User
import com.elhady.emitter.utils.Status


/**
 * Created by islam elhady on 08-Nov-21.
 */
//@BindingAdapter("usersApiStatus")
//fun bindStatus(statusImageView: ImageView, status: Status?) {
//    when (status) {
//        Status.LOADING -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.loading_animation)
//        }
//        Status.ERROR -> {
//            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.ic_connection_error)
//        }
//        Status.DONE -> {
//            statusImageView.visibility = View.GONE
//        }
//    }
//}
@BindingAdapter("usersApiStatus")
fun bindStatus(progressBar: ProgressBar, status: Status?) {
    when (status) {
        Status.LOADING -> progressBar.visibility = View.VISIBLE
        Status.ERROR -> progressBar.visibility = View.GONE
        Status.DONE -> progressBar.visibility = View.GONE
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    val adapter = recyclerView.adapter as UsersAdapter
    adapter.submitList(data)
}

@BindingAdapter("itemDecoration")
fun bindItemDecoration(recyclerView: RecyclerView, orientation: Int) {
    val mDividerItemDecoration = DividerItemDecoration(
        recyclerView.context,
        orientation
    )
    recyclerView.addItemDecoration(mDividerItemDecoration)
}

@BindingAdapter("loadingStatus")
fun bindLoadingStatus(swipeRefreshLayout: SwipeRefreshLayout, status: Status?) {
    when (status) {
        Status.LOADING -> swipeRefreshLayout.isRefreshing = true
        Status.ERROR -> swipeRefreshLayout.isRefreshing = false
        Status.DONE -> swipeRefreshLayout.isRefreshing = false
    }
}
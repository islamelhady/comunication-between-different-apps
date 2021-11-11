package com.elhady.receiver.ui.list

import androidx.lifecycle.ViewModel
import com.elhady.receiver.data.repository.UserRepository

/**
 * Created by islam elhady on 11-Nov-21.
 */
class UserListViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val usersList = userRepository.userList

}
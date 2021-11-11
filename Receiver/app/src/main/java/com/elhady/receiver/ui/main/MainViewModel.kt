package com.elhady.receiver.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.receiver.data.model.User
import com.elhady.receiver.data.repository.UserRepository
import kotlinx.coroutines.launch

/**
 * Created by islam elhady on 11-Nov-21.
 */
class MainViewModel(
    private val userRepository: UserRepository
) : ViewModel() {


    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}
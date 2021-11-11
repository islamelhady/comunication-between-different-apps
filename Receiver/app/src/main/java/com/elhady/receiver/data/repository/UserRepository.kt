package com.elhady.receiver.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.elhady.receiver.data.local.UserMapper
import com.elhady.receiver.data.local.dao.UserDao
import com.elhady.receiver.data.model.User

/**
 * Created by islam elhady on 11-Nov-21.
 */
class UserRepository(private val userDao: UserDao, private val mapper: UserMapper) {

    private val _usersList: LiveData<List<User>> =
        userDao.getAllUsers().map { list -> mapper.mapFromEntityList(list) }

    val userList: LiveData<List<User>>
        get() = _usersList

    suspend fun insertUser(user: User) {
        userDao.insert(mapper.mapToEntity(user))
    }

}
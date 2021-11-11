package com.elhady.receiver.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elhady.receiver.data.local.dao.UserDao

/**
 * Created by islam elhady on 11-Nov-21.
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract val userDao: UserDao
}
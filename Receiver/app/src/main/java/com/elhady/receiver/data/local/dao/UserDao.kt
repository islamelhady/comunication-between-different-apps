package com.elhady.receiver.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elhady.receiver.data.local.UserEntity

/**
 * Created by islam elhady on 11-Nov-21.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(night: UserEntity)

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): LiveData<List<UserEntity>>
}
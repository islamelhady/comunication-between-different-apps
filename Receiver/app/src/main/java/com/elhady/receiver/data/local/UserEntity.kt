package com.elhady.receiver.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by islam elhady on 11-Nov-21.
 */
@Entity(tableName = "users_table")
data class UserEntity(
    @PrimaryKey
    var id: Long,
    var name: String,
    var username: String,
    var email: String,
    var phone: String,
    var website: String
)
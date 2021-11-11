package com.elhady.receiver.data.local

import com.elhady.receiver.data.model.User
import com.elhady.receiver.utils.EntityMapper


/**
 * Created by islam elhady on 11-Nov-21.
 */
class UserMapper() : EntityMapper<UserEntity, User> {

    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            username = entity.username,
            email = entity.email,
            phone = entity.phone,
            website = entity.website
        )
    }

    override fun mapToEntity(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            name = model.name,
            username = model.username,
            email = model.email,
            phone = model.phone,
            website = model.website
        )
    }

    fun mapFromEntityList(entities: List<UserEntity>): List<User> {
        return entities.map { mapFromEntity(it) }
    }

}












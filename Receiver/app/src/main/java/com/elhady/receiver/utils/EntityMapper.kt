package com.elhady.receiver.utils

/**
 * Created by islam elhady on 11-Nov-21.
 */
interface EntityMapper<Entity, Model> {

    fun mapFromEntity(entity: Entity): Model

    fun mapToEntity(model: Model): Entity
}
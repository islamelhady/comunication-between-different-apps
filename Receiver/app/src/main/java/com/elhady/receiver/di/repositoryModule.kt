package com.elhady.receiver.di

import com.elhady.receiver.data.repository.UserRepository
import org.koin.dsl.module

/**
 * Created by islam elhady on 11-Nov-21.
 */
val repositoryModule = module {
    single { UserRepository(get(), get()) }
}
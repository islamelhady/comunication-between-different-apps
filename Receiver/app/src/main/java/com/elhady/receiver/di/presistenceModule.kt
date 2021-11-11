package com.elhady.receiver.di

import androidx.room.Room
import com.elhady.receiver.R
import com.elhady.receiver.data.local.UserMapper
import com.elhady.receiver.data.local.UsersDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by islam elhady on 11-Nov-21.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), UsersDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<UsersDatabase>().userDao }
}
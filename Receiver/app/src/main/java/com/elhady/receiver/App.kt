package com.elhady.receiver

import android.app.Application
import com.elhady.receiver.di.repositoryModule
import com.elhady.receiver.di.viewModelModule
import com.elhady.receiver.di.persistenceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 11-Nov-21.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}
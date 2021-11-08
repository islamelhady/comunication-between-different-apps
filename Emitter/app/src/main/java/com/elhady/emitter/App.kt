package com.elhady.emitter

import android.app.Application
import com.elhady.emitter.di.networkModule
import com.elhady.emitter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 08-Nov-21.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(networkModule)
            modules(viewModelModule)
        }
    }
}
package com.elhady.emitter.di

import com.elhady.emitter.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by islam elhady on 08-Nov-21.
 */
val viewModelModule = module {
    viewModel {
        MainViewModel(get(),get())
    }
}
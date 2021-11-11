package com.elhady.receiver.di

import com.elhady.receiver.ui.list.UserListViewModel
import com.elhady.receiver.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by islam elhady on 11-Nov-21.
 */
val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }
    viewModel {
        UserListViewModel(get())
    }
}
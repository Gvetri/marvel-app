package com.example.giuseppe.demoapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.giuseppe.demoapp.di.module.qualifier.ViewModelKey
import com.example.giuseppe.demoapp.viewmodel.ComicDetailViewModel
import com.example.giuseppe.demoapp.viewmodel.MainViewModel
import com.example.giuseppe.demoapp.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ComicDetailViewModel::class)
    abstract fun bindComicDetailViewModel(viewModel: ComicDetailViewModel): ViewModel

}

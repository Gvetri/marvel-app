package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.ui.fragments.ComicDetailFragment
import com.example.giuseppe.demoapp.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeComicDetailFragment(): ComicDetailFragment
}

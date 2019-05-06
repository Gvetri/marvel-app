package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.di.scopes.ForActivity
import com.example.giuseppe.demoapp.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ForActivity
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun provideMain(): MainActivity

}

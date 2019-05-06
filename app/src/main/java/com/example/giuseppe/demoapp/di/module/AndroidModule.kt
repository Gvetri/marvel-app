package com.example.giuseppe.demoapp.di.module

import android.app.Application
import android.view.LayoutInflater
import com.example.giuseppe.demoapp.di.module.qualifier.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class AndroidModule {
    @Provides
    fun provideLayoutInflater(@ActivityScope application: Application): LayoutInflater {
        return LayoutInflater.from(application)
    }
}
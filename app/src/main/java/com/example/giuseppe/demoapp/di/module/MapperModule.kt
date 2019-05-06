package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.data.network.mappers.MainDataMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideMainMapper() : MainDataMapper{
        return MainDataMapper()
    }
}
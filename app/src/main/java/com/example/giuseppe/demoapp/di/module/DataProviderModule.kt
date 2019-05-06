package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.data.datasources.ComicDetailProvider
import com.example.giuseppe.demoapp.data.network.NetworkComicDetailDataProvider
import com.example.giuseppe.demoapp.data.network.NetworkMainDataProvider
import com.example.giuseppe.demoapp.data.network.mappers.MainDataMapper
import com.example.giuseppe.demoapp.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataProviderModule {
    @Provides
    @Singleton
    fun provideDataProvider(apiService: ApiService,mainDataMapper: MainDataMapper): NetworkMainDataProvider {
        return NetworkMainDataProvider(apiService,mainDataMapper)
    }
    @Provides
    @Singleton
    fun provideComicDetailProvider(apiService: ApiService): ComicDetailProvider {
        return NetworkComicDetailDataProvider(apiService)
    }
}
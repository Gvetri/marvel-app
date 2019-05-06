package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.data.ComicDetailRepository
import com.example.giuseppe.demoapp.data.MainRepository
import com.example.giuseppe.demoapp.data.network.NetworkComicDetailDataProvider
import com.example.giuseppe.demoapp.data.network.NetworkMainDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(networkMainDataProvider: NetworkMainDataProvider): MainRepository {
        return MainRepository(networkMainDataProvider)
    }


    @Provides
    @Singleton
    fun provideComicDetailRepository(comicDetailDataProvider: NetworkComicDetailDataProvider): ComicDetailRepository {
        return ComicDetailRepository(comicDetailDataProvider)
    }
}

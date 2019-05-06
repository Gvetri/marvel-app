package com.example.giuseppe.demoapp.di.module

import com.example.giuseppe.demoapp.data.ComicDetailRepository
import com.example.giuseppe.demoapp.data.MainRepository
import com.example.giuseppe.demoapp.usecases.ComicDetailUseCase
import com.example.giuseppe.demoapp.usecases.MainUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideMainUseCase(mainRepository: MainRepository): MainUseCase {
        return MainUseCase(mainRepository)
    }

    @Provides
    @Singleton
    fun provideComicDetailUseCase(comicDetailRepository: ComicDetailRepository): ComicDetailUseCase {
        return ComicDetailUseCase(comicDetailRepository)
    }


}
package com.example.giuseppe.demoapp.di.module.network

import com.example.giuseppe.demoapp.network.OkHttpInterceptors
import dagger.Module
import dagger.Provides
import io.reactivex.annotations.NonNull
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton


@Module
class OkHttpInterceptorsModule {
    @Provides
    @Singleton
    @NonNull
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message -> Timber.d(message) }
    }

    @Provides
    @OkHttpInterceptors
    @Singleton
    @NonNull
    fun provideOkHttpInterceptors(@NonNull httpLoggingInterceptor: HttpLoggingInterceptor): List<Interceptor> {
        return listOf<Interceptor>(httpLoggingInterceptor)
    }
}

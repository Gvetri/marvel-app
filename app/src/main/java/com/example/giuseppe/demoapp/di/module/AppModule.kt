package com.example.giuseppe.demoapp.di.module

import android.app.Application
import android.content.Context
import com.example.giuseppe.demoapp.App
import com.example.giuseppe.demoapp.di.module.network.RetrofitModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RetrofitModule::class])
class AppModule(var application: Application) {


    @Provides
    @Singleton
    fun provideApplication(application: Application): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideApp(application: App): App {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

}

package com.example.giuseppe.demoapp.di.component

import com.example.giuseppe.demoapp.App
import com.example.giuseppe.demoapp.di.module.*
import com.example.giuseppe.demoapp.di.module.network.GsonModule
import com.example.giuseppe.demoapp.di.module.network.OkHttpInterceptorsModule
import com.example.giuseppe.demoapp.ui.activities.MainActivity
import com.example.giuseppe.demoapp.ui.fragments.ComicDetailFragment
import com.example.giuseppe.demoapp.ui.fragments.MainFragment
import com.example.giuseppe.demoapp.usecases.ComicDetailUseCase
import com.example.giuseppe.demoapp.usecases.MainUseCase
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    AndroidModule::class,
    GsonModule::class,
    OkHttpInterceptorsModule::class,
    UseCasesModule::class,
    DataProviderModule::class,
    RepositoryModule::class,
    MapperModule::class,
    ViewModelModule::class,
    MainActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun appModule(appModule: AppModule): Builder

        fun okHttpInterceptorsModule(okHttpInterceptorsModule: OkHttpInterceptorsModule): Builder

        fun gsonModule(gsonModule: GsonModule): Builder

        fun androidModule(androidModule: AndroidModule): Builder
    }

    fun inject(application: App)

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    fun getMainUseCase() : MainUseCase

    fun inject(comicDetailFragment : ComicDetailFragment)

    fun getComicDetailUseCase(): ComicDetailUseCase

}

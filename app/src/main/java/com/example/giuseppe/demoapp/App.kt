package com.example.giuseppe.demoapp

import android.app.Activity
import android.app.Application
import com.example.giuseppe.demoapp.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @set:Inject
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        AppInjector.init(this)
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }


    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }
}

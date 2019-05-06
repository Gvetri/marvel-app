package com.example.giuseppe.demoapp.ui.base

import android.annotation.SuppressLint
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
class BaseActivity : AppCompatActivity() {
    val lifecycle = LifecycleRegistry(this)
}

package com.example.giuseppe.demoapp.ui.base

import android.arch.lifecycle.LifecycleRegistry
import android.support.v4.app.Fragment

open class BaseFragment : Fragment() {
    var lifecycleRegistry = LifecycleRegistry(this)

}
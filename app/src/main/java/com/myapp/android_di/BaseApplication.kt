package com.myapp.android_di

import android.app.Application
import com.myapp.android_di.utils.SampleClass
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application() {

    @Inject
    lateinit var sampleClass: SampleClass

    override fun onCreate() {
        super.onCreate()
        sampleClass.doSomeThing()
    }
}
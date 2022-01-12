package com.ethan.bridj

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BridjApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
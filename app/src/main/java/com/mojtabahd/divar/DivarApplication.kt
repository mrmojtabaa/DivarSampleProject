package com.mojtabahd.divar

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class DivarApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}
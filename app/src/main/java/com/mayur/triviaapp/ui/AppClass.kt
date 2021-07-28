package com.mayur.triviaapp.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
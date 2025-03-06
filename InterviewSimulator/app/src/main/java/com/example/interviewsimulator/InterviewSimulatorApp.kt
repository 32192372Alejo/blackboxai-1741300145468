package com.example.interviewsimulator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InterviewSimulatorApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any required dependencies here
    }
}

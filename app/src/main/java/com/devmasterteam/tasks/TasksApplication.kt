package com.devmasterteam.tasks

import android.app.Application
import com.devmasterteam.tasks.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TasksApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TasksApplication)
           modules(loginModule)
        }
    }
}
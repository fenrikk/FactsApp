package com.test.factsapp.other

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FactsApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FactsApp)
            modules(listOf(dataModule, viewModelModule))
        }
    }
}
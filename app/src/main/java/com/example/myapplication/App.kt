package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.ModuleKoin.bicycleModule
import com.example.myapplication.di.ModuleKoin.frameFactoryModule
import com.example.myapplication.di.ModuleKoin.wheelDealerModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


@HiltAndroidApp
class App: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(bicycleModule, wheelDealerModule, frameFactoryModule)
        }
    }
}
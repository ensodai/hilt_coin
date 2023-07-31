package com.example.myapplication.di

import com.example.myapplication.BicycleFactory
import com.example.myapplication.FrameFactory
import com.example.myapplication.WheelDealer
import org.koin.dsl.module

object ModuleKoin {

    val bicycleModule = module {
        single { BicycleFactory(get(), get()) }
    }

    val wheelDealerModule = module {
        single { WheelDealer() }
    }

    val frameFactoryModule = module {
        single { FrameFactory() }
    }

}
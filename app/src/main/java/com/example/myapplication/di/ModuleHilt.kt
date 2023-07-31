package com.example.myapplication.di
import com.example.myapplication.BicycleFactory
import com.example.myapplication.FrameFactory
import com.example.myapplication.WheelDealer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleHilt {

    @Provides
    @Singleton
    @Named("wheelDealer")
    fun provideWheelDealer(): WheelDealer = WheelDealer()

    @Provides
    @Singleton
    @Named("frameFactory")
    fun provideFrameFactory(): FrameFactory = FrameFactory()

    @Provides
    fun provideBicycleFactory(
        @Named("wheelDealer") wheelDealer: WheelDealer,
        @Named("frameFactory") frameFactory: FrameFactory
    ): BicycleFactory {
        return BicycleFactory(wheelDealer,frameFactory)
    }

}
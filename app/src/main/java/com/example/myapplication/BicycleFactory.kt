package com.example.myapplication


class BicycleFactory (
    private val wheelDealer: WheelDealer,
    private val frameFactory: FrameFactory
) {

    fun build(
        color: ColorBicycle,
        logo: Logo
    ): Bicycle {
        val wheel = wheelDealer.getWheel()
        val frame = frameFactory.getFrame(color = color)
        return Bicycle(wheel = wheel, frame = frame, logo = logo)
    }

}
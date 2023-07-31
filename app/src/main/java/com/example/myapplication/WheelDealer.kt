package com.example.myapplication

import android.util.Log

class WheelDealer {

    fun getWheel(): Wheel {
        val serialNumber = (0..1000).random()
        Log.d("Wheel number", serialNumber.toString())
        return Wheel(serialNumber)
    }

}
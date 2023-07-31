package com.example.myapplication

import android.util.Log

class FrameFactory() {

    fun getFrame(color: ColorBicycle): Frame {
        val serialNumber = (0..199).random()
        Log.d("Frame Number", serialNumber.toString() )
        return Frame(serialNumber = serialNumber, colorBicycle = color)
    }

}
package com.example.minhascores
import android.graphics.Color

class NewCor() {
    private var redValue: Int = 0
    private var greenValue: Int = 0
    private var blueValue: Int = 0

    fun setRed(value: Int) {
        redValue = value
    }

    fun setGreen(value: Int) {
        greenValue = value
    }

    fun setBlue(value: Int) {
        blueValue = value
    }

    fun toInt(): Int {
        return Color.rgb(redValue, greenValue, blueValue)
    }

    fun toIntReverse(): Int {
        return Color.rgb(255 - redValue, 255 - greenValue, 255 - blueValue)
    }

    override fun toString(): String {
        return toInt().toString()
    }

    fun toHex(): String {
        return "#" + Integer.toHexString( toInt() ).uppercase().substring(2,8)
    }
}
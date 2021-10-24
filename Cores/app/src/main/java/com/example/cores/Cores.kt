package com.example.cores

import android.graphics.Color
import kotlin.random.Random

class Cores {

    private var color: MutableSet<Int> = mutableSetOf();

    constructor() {
        this.color.add( this.setColor() );
    }

    private fun setColor(): Int {
        return Color.rgb( Random.nextInt(255), Random.nextInt(255), Random.nextInt(255));
    }

    override fun toString(): String {
        return this.color.toString().replace("\\[|]".toRegex(),"");
    }
}

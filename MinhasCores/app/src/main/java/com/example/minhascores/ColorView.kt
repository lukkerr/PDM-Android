package com.example.minhascores

import android.graphics.Color

var CODIGO = 0L

class ColorView {

    var id: Long
    var name: String
    var code: String

    constructor(id: Long, nome: String, codigo: String){
        this.id = id
        this.name = nome
        this.code = codigo
    }

    constructor(nome: String, codigo: String){
        this.id = ++CODIGO
        this.name = nome
        this.code = codigo
    }

    fun color(): Int{
        return Color.parseColor(code)
    }
}
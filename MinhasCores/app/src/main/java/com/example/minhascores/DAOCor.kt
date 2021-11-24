package com.example.minhascores

import android.content.ContentValues
import android.content.Context

class DAO {
    private var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    fun insert (cor: ColorView) {
        val cv =  ContentValues()
        cv.put ("name", cor.code)
        cv.put ("code", cor.name)

        this.banco.writableDatabase.insert("cores", null, cv)
    }

    fun count(): Int {
        var sql = "select count(id) from cores"
        val cursor = this.banco.readableDatabase.rawQuery(sql, null)

        cursor.moveToFirst()

        return cursor.getInt(0)
    }


    fun get(): ArrayList<ColorView> {
        val lista = ArrayList<ColorView> ()
        val colunas = arrayOf("id", "name", "code")
        val cursor = this.banco.readableDatabase.query("cores", colunas, null, null, null, null, "id")

        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getLong(0)
            val name = cursor.getString(1)
            val code = cursor.getString(2)
            lista.add(ColorView(id, name, code))
            cursor.moveToNext()
        }

        return lista


    }

    fun find(id: Int): ColorView?{
        val colunas = arrayOf("id", "nome", "codigo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query("cores", colunas, where, pWhere, null, null, null)
        cursor.moveToFirst()
        if (cursor.count == 1){
            val id = cursor.getLong(0)
            val name = cursor.getString(1)
            val code = cursor.getString(2)
            return ColorView(id, name, code)
        }
        return null
    }

    fun update(cor: ColorView){
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())

        val cv = ContentValues()
        cv.put("name", cor.name)
        cv.put("code", cor.code)

        this.banco.writableDatabase.update("cores", cv, where, pWhere)
    }

    fun delete(id: Long){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("cores", where, pWhere)
    }
}
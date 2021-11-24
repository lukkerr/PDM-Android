package com.example.minhascores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var buttonAdd: Button
    private lateinit var dao: DAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.listView = findViewById(R.id.listView)
        this.listView.setOnItemLongClickListener { parent, view, position, id -> deleteItem(position) }
        this.dao = DAO(this)
        this.update()

        if(listView.adapter.count < 1) {
            this.update( ColorView("cor exemplo","#FF0000") )
        }

        this.buttonAdd = findViewById(R.id.button)
        this.buttonAdd.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        if(intent !== null) {
            val color = intent.getStringExtra("COLOR")
            if(color != null) {
                val newColor = ColorView(color.replaceFirst("-"," ").split(" ").get(0),
                    color.replaceFirst("-"," ").split(" ").get(1))
                System.out.println( newColor.code )
                save(newColor)
            }
        }
    }

    fun deleteItem(position: Int): Boolean {
        dao.delete( listView.adapter.getItemId(position) )
        update()
        return true
    }

    private fun update(color: ColorView? = null) {
        val list = dao.get()
        if(color != null)
            list.add(color)

        this.listView.adapter = CorAdapter(this, list)
    }

    private fun save(cor: ColorView) {
        dao.insert(cor)
        update()
    }
}
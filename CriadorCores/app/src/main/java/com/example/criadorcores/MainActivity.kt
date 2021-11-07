package com.example.criadorcores

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewColor : View
    private lateinit var text : TextView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewColor = findViewById(R.id.viewColor)
        text = findViewById(R.id.text)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent( this, SecondActivity::class.java )

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            }
        }

        if(intent !== null) {
            val color = intent.getStringExtra("COLOR")
            if(color != null) {
                text.text = color
                viewColor.setBackgroundColor( Color.parseColor(color) )
            }
        }
    }
}
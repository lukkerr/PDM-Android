package com.example.cores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var display: View;
    private lateinit var textView: TextView;
    private lateinit var button: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.display = findViewById(R.id.display);
        this.textView = findViewById(R.id.text);
        this.button = findViewById(R.id.button);

        this.updateColor();
        this.button.setOnClickListener{ this.updateColor() };
    }

    private fun updateColor() {
        val color = Cores().toString();
        this.display.setBackgroundColor( color.toInt() );
        this.textView.text = color;
    }
}
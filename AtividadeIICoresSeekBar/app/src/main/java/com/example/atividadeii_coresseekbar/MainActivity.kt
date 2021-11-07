package com.example.atividadeii_coresseekbar

import Cor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var cor: Cor = Cor()
    lateinit var viewColor: View
    lateinit var textColor: TextView
    lateinit var seekRed: SeekBar
    lateinit var seekGreen: SeekBar
    lateinit var seekBlue: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cor = Cor()

        viewColor = findViewById(R.id.view)
        viewColor.setBackgroundColor( cor.toInt() )

        textColor = findViewById(R.id.textColor)
        textColor.setText( cor.toHex() );
        textColor.setTextColor( cor.toIntReverse() )

        seekRed = findViewById(R.id.redSeek)
        seekRed.setOnSeekBarChangeListener( OnChange() )

        seekGreen = findViewById(R.id.greenSeek)
        seekGreen.setOnSeekBarChangeListener( OnChange() )

        seekBlue = findViewById(R.id.blueSeek)
        seekBlue.setOnSeekBarChangeListener( OnChange() )
    }

    inner class OnChange:SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            cor.setRed(seekRed.progress)
            cor.setGreen(seekGreen.progress)
            cor.setBlue(seekBlue.progress)

            viewColor.setBackgroundColor( cor.toInt() )
            textColor.setText( cor.toHex() )
            textColor.setTextColor( cor.toIntReverse() )
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}
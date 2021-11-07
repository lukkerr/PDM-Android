package com.example.criadorcores

import Cor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.example.criadorcores.MainActivity
import com.example.criadorcores.R

class SecondActivity : AppCompatActivity() {
    private var cor: Cor = Cor()
    lateinit var viewColor: View
    lateinit var textColor: TextView

    lateinit var seekRed: SeekBar
    lateinit var redTextValue: TextView
    lateinit var seekGreen: SeekBar
    lateinit var greenTextValue: TextView
    lateinit var seekBlue: SeekBar
    lateinit var blueTextValue: TextView

    lateinit var buttonSalvar: Button
    lateinit var buttonCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        cor = Cor()

        viewColor = findViewById(R.id.view)
        viewColor.setBackgroundColor( cor.toInt() )

        textColor = findViewById(R.id.textColor)
        textColor.text = cor.toHex();
        textColor.setTextColor( cor.toIntReverse() )

        seekRed = findViewById(R.id.redSeek)
        seekRed.setOnSeekBarChangeListener( OnChange() )

        seekGreen = findViewById(R.id.greenSeek)
        seekGreen.setOnSeekBarChangeListener( OnChange() )

        seekBlue = findViewById(R.id.blueSeek)
        seekBlue.setOnSeekBarChangeListener( OnChange() )

        redTextValue = findViewById(R.id.redTextValue)
        greenTextValue = findViewById(R.id.greenTextValue)
        blueTextValue = findViewById(R.id.blueTextValue)

        buttonSalvar = findViewById(R.id.buttonSalvar)
        buttonSalvar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("COLOR", cor.toHex() );
            }

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        buttonCancelar = findViewById(R.id.buttonCancelar)
        buttonCancelar.setOnClickListener{
            this.finish()
        }
    }

    inner class OnChange:SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            cor.setRed(seekRed.progress)
            cor.setGreen(seekGreen.progress)
            cor.setBlue(seekBlue.progress)

            redTextValue.text = seekRed.progress.toString()
            greenTextValue.text = seekGreen.progress.toString()
            blueTextValue.text = seekBlue.progress.toString()

            viewColor.setBackgroundColor( cor.toInt() )
            textColor.setText( cor.toHex() )
            textColor.setTextColor( cor.toIntReverse() )
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}
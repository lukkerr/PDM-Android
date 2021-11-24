package com.example.minhascores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private var newCor: NewCor = NewCor()
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
    lateinit var inputName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        newCor = NewCor()

        viewColor = findViewById(R.id.view)
        viewColor.setBackgroundColor( newCor.toInt() )

        textColor = findViewById(R.id.textColor)
        textColor.text = newCor.toHex();
        textColor.setTextColor( newCor.toIntReverse() )

        seekRed = findViewById(R.id.redSeek)
        seekRed.setOnSeekBarChangeListener( OnChange() )

        seekGreen = findViewById(R.id.greenSeek)
        seekGreen.setOnSeekBarChangeListener( OnChange() )

        seekBlue = findViewById(R.id.blueSeek)
        seekBlue.setOnSeekBarChangeListener( OnChange() )

        redTextValue = findViewById(R.id.redTextValue)
        greenTextValue = findViewById(R.id.greenTextValue)
        blueTextValue = findViewById(R.id.blueTextValue)

        inputName = findViewById(R.id.inputName)

        buttonSalvar = findViewById(R.id.buttonSalvar)
        buttonSalvar.setOnClickListener{
            if(!inputName.text.trim().isBlank()) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("COLOR", newCor.toHex() + "-" + inputName.text.trim() );
                }

                if(intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }

        buttonCancelar = findViewById(R.id.buttonCancelar)
        buttonCancelar.setOnClickListener{
            this.finish()
        }
    }

    inner class OnChange:SeekBar.OnSeekBarChangeListener {

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            newCor.setRed(seekRed.progress)
            newCor.setGreen(seekGreen.progress)
            newCor.setBlue(seekBlue.progress)

            redTextValue.text = seekRed.progress.toString()
            greenTextValue.text = seekGreen.progress.toString()
            blueTextValue.text = seekBlue.progress.toString()

            viewColor.setBackgroundColor( newCor.toInt() )
            textColor.setText( newCor.toHex() )
            textColor.setTextColor( newCor.toIntReverse() )
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }

}
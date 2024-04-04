package com.example.calculateimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var texWeight: TextView
    private lateinit var textHeight: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        texWeight = findViewById(R.id.textWeight)
        textHeight = findViewById(R.id.textHeight)
        textResult = findViewById(R.id.textResult)

        val bundle = intent.extras
        if ( bundle != null ){
            
            val weight = bundle.getDouble("weight")
            val height = bundle.getDouble("height")

            textHeight.text = "Reported weight $weight kg"
            textHeight.text = "Reported height $height m"


            val imc = weight / (height * height)

            val result = if( imc < 18.5 ){
                "Baixo"
            }else if ( imc in 18.5 ..24.9){
                "Normal"

            }else if ( imc in 25.0 ..29.9){
                "Sobrepeso"

            }else{
                "Obeso"
            }
            textResult.text = result
        }

    }
}
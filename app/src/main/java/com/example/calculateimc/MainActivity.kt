package com.example.calculateimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.calculateimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var btnCalculate: Button
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCalculate = findViewById(R.id.btnCalculate)
        editWeight = findViewById(R.id.editWeight)
        editHeight = findViewById(R.id.editHeight)


        btnCalculate.setOnClickListener {

            val intent = Intent(this, ResultActivity::class.java)

            val weight = editWeight.text.toString()
            val height = editHeight.text.toString()

            if( weight.isNotEmpty() && height.isNotEmpty() ){

                intent.putExtra("weight", weight.toDouble())
                intent.putExtra("height", height.toDouble())
            }


            startActivity( intent )
        }


    }

}
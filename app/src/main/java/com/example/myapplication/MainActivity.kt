package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val boton = findViewById<Button>(R.id.boton) // definir un elemento

        

        val boton: Button = findViewById(R.id.boton)
        boton.setOnClickListener {
            val intent = Intent(this, MySecondActivity::class.java)
            startActivity(intent)
        }
    }
}

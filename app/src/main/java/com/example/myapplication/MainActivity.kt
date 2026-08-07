package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val boton = findViewById<Button>(R.id.boton) // definir un elemento



        val boton: Button = findViewById(R.id.boton)
        val nombreUsuario: EditText = findViewById(R.id.nombreUsuario)

        boton.setOnClickListener {
            val intent = Intent(this, MySecondActivity::class.java)
            intent.putExtra("nombre_usuario", nombreUsuario.text.toString())
            startActivity(intent)
        }
    }
}

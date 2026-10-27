package com.example.contadorviews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserContador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_contador)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextComptador = findViewById<EditText>(R.id.editTextContador)

        val contador = intent.getIntExtra("NUMBER_COUNT",0).apply { editTextComptador.setText("$this") }

        val inicio = findViewById<Button>(R.id.inicio)

        inicio.setOnClickListener {
            val nextPantalla = Intent(this, MainActivity::class.java)
            nextPantalla.putExtra("NUMBER_COUNT", contador)
            startActivity(nextPantalla)
        }
    }
}
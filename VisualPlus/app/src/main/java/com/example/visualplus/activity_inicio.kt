package com.example.visualplus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_inicio : AppCompatActivity() {

    private lateinit var loginBtninicio: Button
    private lateinit var loginBtnregistro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginBtninicio = findViewById(R.id.inicio_btn)

        loginBtninicio.setOnClickListener {
            // para redirigir boton de inicio de sesion
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        loginBtnregistro = findViewById(R.id.registro_btn)

        loginBtnregistro.setOnClickListener {
            val intent = Intent(this, activity_registro::class.java)
            startActivity(intent)
        }

    }
}
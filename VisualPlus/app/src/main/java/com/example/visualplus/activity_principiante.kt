package com.example.visualplus

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_principiante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principiante)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Definir array de rutina de principiante
        val rutinaPrincipiante = arrayOf(
            "Objetivo: Mejorar movilidad y la resistencia cardiovascular basica.",
            "1. Calentamiento: Marcha en el lugar - 3 minutos",
            "2. Sentadilla asistida: 3 series de 15 segundos",
            "3. Elevación de rodillas: 3 series de 15 segundos",
            "4. Flexiones de pared: 3 series de 8 repeticiones",
            "5. Estiramiento básico: 5 minutos"
        )

        val textView: TextView = findViewById(R.id.rutina_text)

        // Concatenar las rutinas
        val concatenatedRutinaPrincipiante = rutinaPrincipiante.joinToString(separator = "\n\n")

        textView.text = concatenatedRutinaPrincipiante
    }
}

package com.example.visualplus.firebase

data class Rutina(
    val nombre: String = "",
    val nivel: String = "", // Ejemplo: "Principiante", "Intermedio", "Avanzado"
    val duracion: Int = 0,  // Duración en minutos
    val ejercicios: List<String> = listOf(), // Lista de ejercicios
    val activa: Boolean = true // Estado de la rutina
)

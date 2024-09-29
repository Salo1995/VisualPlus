package com.example.visualplus.firebase

import com.google.firebase.firestore.FirebaseFirestore

object RutinaRepository {
    private val db = FirebaseFirestore.getInstance()

    // Función para agregar una rutina
    fun addRutina(rutina: Rutina, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("rutinas")
            .add(rutina)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }
    }

    // Función para leer rutinas
    fun getRutinas(onRutinasLoaded: (List<Rutina>) -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("rutinas")
            .get()
            .addOnSuccessListener { result ->
                val rutinas = result.map { document ->
                    document.toObject(Rutina::class.java)
                }
                onRutinasLoaded(rutinas)
            }
            .addOnFailureListener { e -> onFailure(e) }
    }

    // Función para actualizar una rutina
    fun updateRutina(rutinaId: String, newDuracion: Int, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("rutinas").document(rutinaId)
            .update("duracion", newDuracion)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }
    }

    // Función para eliminar una rutina
    fun deleteRutina(rutinaId: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("rutinas").document(rutinaId)
            .delete()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }
    }
}

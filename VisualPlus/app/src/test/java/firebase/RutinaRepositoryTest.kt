package com.example.visualplus.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.util.Assert.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class RutinaRepositoryTest {

    private lateinit var mockFirestore: FirebaseFirestore
    private lateinit var mockCollection: CollectionReference
    private lateinit var mockDocumentReference: DocumentReference
    private lateinit var rutinaRepository: RutinaRepository

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this) // Inicializa los mocks
        mockFirestore = mock(FirebaseFirestore::class.java)
        mockCollection = mock(CollectionReference::class.java)
        mockDocumentReference = mock(DocumentReference::class.java)

        // Simula que db.collection("rutinas") devuelve la colección simulada
        `when`(mockFirestore.collection("rutinas")).thenReturn(mockCollection)
        `when`(mockCollection.add(any(Rutina::class.java))).thenReturn(mock(Task::class.java) as Task<DocumentReference>?)

        rutinaRepository = RutinaRepository // Usa el objeto simulado de Firestore
    }

    @Test
    fun `test addRutina success`() {
        val testRutina = Rutina("Rutina de prueba", "Principiante", 30, listOf("Ejercicio1"), true)

        rutinaRepository.addRutina(testRutina,
            onSuccess = {
                println("Rutina añadida correctamente.")
            },
            onFailure = {
                fail("La adición de la rutina falló: ${it.message}")
            }
        )

        verify(mockCollection).add(testRutina) // Verifica que se haya llamado a add con la rutina
    }
}

package com.example.visualplus

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visualplus.firebase.Rutina
import com.example.visualplus.firebase.RutinaRepository
import com.example.visualplus.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RutinaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RutinasScreen()
        }
    }

    @Composable
    fun RutinasScreen() {
        var nombre by remember { mutableStateOf("") }
        var nivel by remember { mutableStateOf("") }
        var duracion by remember { mutableStateOf("") }
        var activa by remember { mutableStateOf(false) }
        val rutinas = remember { mutableStateListOf<Rutina>() }
        val context = LocalContext.current

        val gradientColors = listOf(
            Color(0xFF201D1D),
            Color(0xFFFFFFFF)
        )

        // Leer rutinas al iniciar desde Firebase Storage con Retrofit
        LaunchedEffect(Unit) {
            try {
                val loadedRutinas = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getRutinas()
                }
                rutinas.clear()
                rutinas.addAll(loadedRutinas)
                makeText(context, "Rutinas cargadas con éxito", LENGTH_SHORT).show()
            } catch (e: Exception) {
                makeText(context, "Error al cargar rutinas: ${e.message}", LENGTH_SHORT).show()
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(gradientColors)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Formulario para añadir rutina
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre de la Rutina") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = nivel,
                    onValueChange = { nivel = it },
                    label = { Text("Nivel (Ej. Principiante, Intermedio, Avanzado)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = duracion,
                    onValueChange = { duracion = it },
                    label = { Text("Duración (minutos)") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Activa")
                    Checkbox(
                        checked = activa,
                        onCheckedChange = { activa = it }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    val rutina = Rutina(nombre, nivel, duracion.toInt(), listOf(), activa)
                    RutinaRepository.addRutina(
                        rutina,
                        onSuccess = {
                            makeText(context, "Rutina añadida con éxito", LENGTH_SHORT).show()
                            nombre = ""
                            nivel = ""
                            duracion = ""
                            activa = false
                        },
                        onFailure = {
                            makeText(context, "Error al añadir rutina: ${it.message}", LENGTH_SHORT).show()
                        }
                    )
                }) {
                    Text("Añadir Rutina")
                }

                // Mostrar rutinas
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(rutinas.size) { index ->
                        val rutina = rutinas[index]
                        CardRutinaItem(rutina)
                    }
                }
            }
        }
    }

    @Composable
    fun CardRutinaItem(rutina: Rutina) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Nombre: ${rutina.nombre}")
                Text(text = "Nivel: ${rutina.nivel}")
                Text(text = "Duración: ${rutina.duracion} minutos")
                Text(text = "Activa: ${rutina.activa}")
            }
        }
    }

    @Preview
    @Composable
    fun PrevRutinaScreen() {
        RutinasScreen()
    }
}

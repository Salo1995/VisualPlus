package com.example.visualplus

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visualplus.ui.theme.VisualPlusTheme

class ActivityInicio : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usar setContent en lugar de setContentView
        setContent {
            VisualPlusTheme {
                ActivityInicioScreen(
                    onLoginClick = {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    },
                    onRegisterClick = {
                        val intent = Intent(this, ActivityRegistro::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun ActivityInicioScreen(onLoginClick: () -> Unit, onRegisterClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título del mensaje
        Text(
            text = "Ejercítate con confianza: alertas visuales y táctiles para ti",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón de inicio de sesión
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Text(text = "Iniciar Sesión", fontSize = 20.sp)
        }

        // Botón de registro
        Button(
            onClick = onRegisterClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Text(text = "Registrarse", fontSize = 20.sp)
        }
    }
}

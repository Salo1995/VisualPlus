package com.example.visualplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class activity_principiante : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    ActivityPrincipianteScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityPrincipianteScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.my_backgroun),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Contenido sobre la imagen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Toolbar (TopAppBar en lugar de Toolbar XML)
            TopAppBar(
                title = {
                    Text(
                        text = "Rutina Nivel Principiante",
                        fontSize = 25.sp,
                        color = Color.White
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Rutina (TextView en XML)
            Text(
                text = "Objetivo: Mejorar movilidad y la resistencia cardiovascular básica\n\n" +
                        "1. Calentamiento: Marcha en el lugar - 3 minutos\n" +
                        "2. Sentadilla asistida: 3 series de 15 segundos\n" +
                        "3. Elevación de rodillas: 3 series de 15 segundos\n" +
                        "4. Flexiones de pared: 3 series de 8 repeticiones\n" +
                        "5. Estiramiento básico: 5 minutos",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                lineHeight = 24.sp
            )
        }
    }
}

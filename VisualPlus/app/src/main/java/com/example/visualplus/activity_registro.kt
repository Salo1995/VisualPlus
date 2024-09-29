package com.example.visualplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ActivityRegistro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    ActivityRegistroScreen(
                        onRegistrarseClick = {  }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityRegistroScreen(onRegistrarseClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Toolbar (TopAppBar en lugar de Toolbar XML)
        TopAppBar(
            title = {
                Text(
                    text = "Registro",
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

        // Logo (ImageView en XML)
        Image(
            painter = painterResource(id = R.drawable.logo_visualplus),
            contentDescription = null,
            modifier = Modifier
                .size(178.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para Nombre (EditText en XML)
        OutlinedTextField(
            value = "",
            onValueChange = { /* Actualiza el valor del campo aquí */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.str_nombre), color = Color.Gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        // Campo de texto para Apellido (EditText en XML)
        OutlinedTextField(
            value = "",
            onValueChange = { /* Actualiza el valor del campo aquí */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.str_apellido), color = Color.Gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        // Campo de texto para Correo (EditText en XML)
        OutlinedTextField(
            value = "",
            onValueChange = { /* Actualiza el valor del campo aquí */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.str_usuario), color = Color.Gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        // Campo de texto para Clave (EditText en XML)
        OutlinedTextField(
            value = "",
            onValueChange = { /* Actualiza el valor del campo aquí */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = {
                Text(text = stringResource(id = R.string.str_clave), color = Color.Gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de Registro (Button en XML)
        Button(
            onClick = onRegistrarseClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.str_registro),
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

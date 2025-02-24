package com.example.visualplus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class activity_recuperar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    ActivityRecuperarScreen(
                        onRecuperarClick = { }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityRecuperarScreen(onRecuperarClick: () -> Unit) {
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
                        text = stringResource(id = R.string.str_recuperar),
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

            Spacer(modifier = Modifier.height(32.dp))

            // Imagen de logo (ImageView en XML)
            Image(
                painter = painterResource(id = R.drawable.logo_visualplus),
                contentDescription = null,
                modifier = Modifier.size(220.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Campo de texto (EditText en XML)
            OutlinedTextField(
                value = "",
                onValueChange = { /* Actualiza el valor del campo aquí */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.str_usuario),
                        color = Color.Gray
                    )
                },
                colors = outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.Gray
                ),
                shape = RoundedCornerShape(8.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de Recuperar (Button en XML)
            Button(
                onClick = onRecuperarClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.str_recuperar),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}
